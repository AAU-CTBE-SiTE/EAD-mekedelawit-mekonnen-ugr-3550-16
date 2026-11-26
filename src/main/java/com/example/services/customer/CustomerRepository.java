package com.example.services.customer;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

@Profile("customer")
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
