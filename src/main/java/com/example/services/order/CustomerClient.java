package com.example.services.order;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

@Profile("order")
@Component
public class CustomerClient {

    private final RestClient customerRestClient;

    public CustomerClient(RestClient customerRestClient) {
        this.customerRestClient = customerRestClient;
    }

    public CustomerInfo getCustomerById(String customerId) {
        try {
            return customerRestClient.get()
                    .uri("/api/customers/{id}", customerId)
                    .retrieve()
                    .body(CustomerInfo.class);
        } catch (HttpClientErrorException.NotFound ex) {
            return null;
        }
    }
}
