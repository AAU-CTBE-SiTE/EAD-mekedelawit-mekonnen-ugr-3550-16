package com.example.services.order;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Profile("order")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;

    public OrderController(OrderRepository orderRepository, CustomerClient customerClient) {
        this.orderRepository = orderRepository;
        this.customerClient = customerClient;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest req) {
        if (req.customerId() == null || req.customerId().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "customerId is required"));
        }

        CustomerInfo customer = customerClient.getCustomerById(req.customerId());
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Customer not found: " + req.customerId()));
        }

        if (orderRepository.existsByCustomerId(req.customerId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Customer already has an order: " + req.customerId()));
        }

        Order saved = orderRepository.save(new Order(req.customerId(), req.itemName(), req.amount()));
        return ResponseEntity.status(HttpStatus.CREATED).body(new OrderWithCustomerResponse(
                saved.getId(), saved.getItemName(), saved.getAmount(), saved.getCreatedAt(), customer
        ));
    }

    @GetMapping("/by-customer/{customerId}")
    public ResponseEntity<?> getOrderByCustomer(@PathVariable String customerId) {
        CustomerInfo customer = customerClient.getCustomerById(customerId);
        if (customer == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Customer not found: " + customerId));
        }

        Order order = orderRepository.findByCustomerId(customerId).orElse(null);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "No order found for customer: " + customerId));
        }

        return ResponseEntity.ok(new OrderWithCustomerResponse(
                order.getId(), order.getItemName(), order.getAmount(), order.getCreatedAt(), customer
        ));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getCustomerByOrder(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Order not found: " + orderId));
        }

        CustomerInfo customer = customerClient.getCustomerById(order.getCustomerId());
        return ResponseEntity.ok(new OrderWithCustomerResponse(
                order.getId(), order.getItemName(), order.getAmount(), order.getCreatedAt(), customer
        ));
    }
}
