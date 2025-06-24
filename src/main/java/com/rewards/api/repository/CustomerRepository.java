package com.rewards.api.repository;

import com.rewards.api.model.Customer;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAllCustomers();
}
