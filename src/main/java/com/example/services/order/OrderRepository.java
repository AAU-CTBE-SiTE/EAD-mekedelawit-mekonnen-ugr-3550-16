package com.example.services.order;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Profile("order")
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByCustomerId(String customerId);
    boolean existsByCustomerId(String customerId);
}
