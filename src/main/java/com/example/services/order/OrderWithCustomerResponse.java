package com.example.services.order;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderWithCustomerResponse(
        Long orderId,
        String itemName,
        BigDecimal amount,
        Instant createdAt,
        CustomerInfo customer
) {}
