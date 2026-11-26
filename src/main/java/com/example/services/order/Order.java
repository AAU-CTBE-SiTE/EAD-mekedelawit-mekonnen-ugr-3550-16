package com.example.services.order;

import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.Instant;

@Profile("order")
@Entity
@Table(
    name = "orders",
    uniqueConstraints = @UniqueConstraint(name = "uk_orders_customer_id", columnNames = "customer_id")
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", nullable = false, unique = true)
    private String customerId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    public Order() {}

    public Order(String customerId, String itemName, BigDecimal amount) {
        this.customerId = customerId;
        this.itemName = itemName;
        this.amount = amount;
    }

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = Instant.now();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public Instant getCreatedAt() { return createdAt; }
}
