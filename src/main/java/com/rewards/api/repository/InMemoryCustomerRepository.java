package com.rewards.api.repository;

import com.rewards.api.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private static final List<Customer> CUSTOMERS = Arrays.asList(
            new Customer(1L, "John Doe"),
            new Customer(2L, "Jane Smith"),
            new Customer(3L, "Robert Johnson")
    );

    @Override
    public List<Customer> findAllCustomers() {
        return CUSTOMERS;
    }
}
