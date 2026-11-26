package com.example.services.order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

@Profile("order")
@Configuration
public class RestClientConfig {

    @Bean
    public RestClient customerRestClient(
            RestClient.Builder builder,
            @Value("${customer.service.base-url}") String baseUrl) {
        return builder.baseUrl(baseUrl).build();
    }
}
