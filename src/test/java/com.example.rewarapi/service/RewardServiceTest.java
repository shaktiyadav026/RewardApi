package com.example.rewarapi.service;

import com.example.rewardapi.exception.CustomerNotFoundException;
import com.example.rewardapi.model.RewardResponse;
import com.example.rewardapi.service.RewardService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for RewardService.
 */
class RewardServiceTest {

    private final RewardService rewardService = new RewardService();

    @Test
    void testCalculateRewards_validCustomer_C1() {
        RewardResponse response = rewardService.calculateRewards("C1");

        assertEquals("C1", response.getCustomerId());
        assertEquals(2, response.getMonthlyPoints().size());
        assertEquals(185, response.getTotalPoints());
        assertEquals(115, response.getMonthlyPoints().get("January"));
        assertEquals(70, response.getMonthlyPoints().get("February"));
    }

    @Test
    void testCalculateRewards_validCustomer_C2() {
        RewardResponse response = rewardService.calculateRewards("C2");

        assertEquals("C2", response.getCustomerId());
        assertEquals(3, response.getMonthlyPoints().size());
        assertEquals(405, response.getTotalPoints());
        assertEquals(45, response.getMonthlyPoints().get("January"));
        assertEquals(250, response.getMonthlyPoints().get("February"));
        assertEquals(110, response.getMonthlyPoints().get("March"));
    }

    @Test
    void testCalculateRewards_validCustomer_NoPoints() {
        RewardResponse response = rewardService.calculateRewards("C3");

        assertEquals("C3", response.getCustomerId());
        assertEquals(1, response.getMonthlyPoints().size());
        assertEquals(0, response.getTotalPoints());
    }

    @Test
    void testCalculateRewards_customerNotFound() {
        Exception ex = assertThrows(CustomerNotFoundException.class, () ->
                rewardService.calculateRewards("UNKNOWN"));

        assertEquals("Customer with ID 'UNKNOWN' not found.", ex.getMessage());
    }
}
