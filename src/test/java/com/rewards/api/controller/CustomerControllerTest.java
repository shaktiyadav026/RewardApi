package com.rewards.api.controller;

import com.rewards.api.model.Customer;
import com.rewards.api.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Controller returns customer list correctly
    @Test
    void testGetAllCustomers_Positive() {
        List<Customer> mockCustomers = Arrays.asList(
                new Customer(1L, "John Doe"),
                new Customer(2L, "Jane Smith")
        );

        Mockito.when(customerService.getAllCustomers()).thenReturn(mockCustomers);

        List<Customer> result = customerController.getAllCustomers();

        assertNotNull(result);
        assertEquals(2, result.size(), "Should return 2 customers");
    }

    // Controller returns empty list when no customers exist
    @Test
    void testGetAllCustomers_Empty() {
        Mockito.when(customerService.getAllCustomers()).thenReturn(Collections.emptyList());

        List<Customer> result = customerController.getAllCustomers();

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty list");
    }

    // Verify that controller correctly handles a single customer
    @Test
    void testGetAllCustomers_SingleCustomer() {
        List<Customer> mockCustomers = List.of(
                new Customer(1L, "Single User")
        );

        Mockito.when(customerService.getAllCustomers()).thenReturn(mockCustomers);

        List<Customer> result = customerController.getAllCustomers();

        assertNotNull(result);
        assertEquals(1, result.size(), "Should return one customer");
        assertEquals("Single User", result.get(0).getCustomerName(), "Customer name should match");
    }

    // Validate controller handles repository/service returning null
    @Test
    void testGetAllCustomers_NullList() {
        Mockito.when(customerService.getAllCustomers()).thenReturn(null);

        List<Customer> result = customerController.getAllCustomers();

        assertNull(result, "Should return null when service returns null");
    }

}
