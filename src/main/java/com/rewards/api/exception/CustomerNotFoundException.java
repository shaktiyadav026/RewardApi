package com.rewards.api.exception;

/**
 * Exception thrown when a customer ID is not found in the system.
 */
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String customerId) {
        super("Customer with ID '" + customerId + "' not found.");
    }
}
