package com.rewards.api.service;

import com.rewards.api.model.Customer;
import com.rewards.api.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {

    private final CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    private final CustomerService customerService = new CustomerService(customerRepository);

    // Validating that customer list is returned correctly
    @Test
    void testGetAllCustomers_Positive() {
        List<Customer> mockCustomers = Arrays.asList(
                new Customer(1L, "John Doe"),
                new Customer(2L, "Jane Smith")
        );

        Mockito.when(customerRepository.findAllCustomers()).thenReturn(mockCustomers);

        List<Customer> result = customerService.getAllCustomers();

        assertNotNull(result, "Customer list should not be null");
        assertEquals(2, result.size(), "Customer list should contain 2 customers");
        assertEquals("Jane Smith", result.get(1).getCustomerName(), "Second customer should be Jane Smith");
    }

    // Customer list should return empty list when no data
    @Test
    void testGetAllCustomers_Empty() {
        Mockito.when(customerRepository.findAllCustomers()).thenReturn(List.of());

        List<Customer> result = customerService.getAllCustomers();

        assertTrue(result.isEmpty(), "Customer list should be empty");
    }

    // Validate retrieval of single customer
    @Test
    void testGetAllCustomers_SingleCustomer() {
        List<Customer> mockCustomers = List.of(
                new Customer(1L, "Single User")
        );

        Mockito.when(customerRepository.findAllCustomers()).thenReturn(mockCustomers);

        List<Customer> result = customerService.getAllCustomers();

        assertNotNull(result);
        assertEquals(1, result.size(), "Should return exactly one customer");
        assertEquals("Single User", result.get(0).getCustomerName(), "Customer name should match");
    }

    // Validate null list handling (if repository misbehaves)
    @Test
    void testGetAllCustomers_NullList() {
        Mockito.when(customerRepository.findAllCustomers()).thenReturn(null);

        List<Customer> result = customerService.getAllCustomers();

        assertNull(result, "Result should be null if repository returns null");
    }

}
