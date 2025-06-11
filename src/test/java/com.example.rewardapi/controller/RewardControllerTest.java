package com.example.rewardapi.controller;

import com.example.rewardapi.RewardapiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for the /api/rewards/{customerId} endpoint.
 */
@SpringBootTest(classes = RewardapiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RewardControllerTest {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    private String buildUrl(String customerId) {
        return "http://localhost:" + port + "/api/rewards/" + customerId;
    }

    @Test
    void testGetRewards_validCustomer() {
        ResponseEntity<Map> response = restTemplate.getForEntity(buildUrl("C1"), Map.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("C1", response.getBody().get("customerId"));
        assertEquals(185, response.getBody().get("totalPoints"));
    }

    @Test
    void testGetRewards_invalidCustomer() {
        try {
            restTemplate.getForEntity(buildUrl("INVALID"), Map.class);
            fail("Expected 404 exception was not thrown");
        } catch (HttpClientErrorException.NotFound ex) {
            assertEquals(404, ex.getRawStatusCode());

            String responseBody = ex.getResponseBodyAsString();
            assertTrue(responseBody.contains("Customer with ID 'INVALID' not found."));
            assertTrue(responseBody.contains("\"error\":\"Customer Not Found\""));
        }
    }
}

