package com.example.services.order;

import java.math.BigDecimal;

public record CreateOrderRequest(String customerId, String itemName, BigDecimal amount) {}
