package com.rewards.api.controller;

import com.rewards.api.model.RewardResponse;
import com.rewards.api.service.RewardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RewardControllerTest {

    @Mock
    private RewardService rewardService;

    @InjectMocks
    private RewardController rewardController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Controller returns rewards list correctly
    @Test
    void testGetAllRewards_Positive() {
        List<RewardResponse> mockRewards = List.of(
                new RewardResponse(1L, Map.of(Month.MARCH, 90), 90)
        );

        Mockito.when(rewardService.calculateRewards()).thenReturn(mockRewards);

        List<RewardResponse> result = rewardController.getAllRewards();

        assertNotNull(result);
        assertEquals(1, result.size(), "Should return 1 reward record");
    }

    // Controller returns empty list when no rewards exist
    @Test
    void testGetAllRewards_Empty() {
        Mockito.when(rewardService.calculateRewards()).thenReturn(Collections.emptyList());

        List<RewardResponse> result = rewardController.getAllRewards();

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Should return empty rewards list");
    }

    // Validate controller returns rewards for multiple customers
    @Test
    void testGetAllRewards_MultipleCustomers() {
        List<RewardResponse> mockRewards = List.of(
                new RewardResponse(1L, Map.of(Month.MARCH, 90), 90),
                new RewardResponse(2L, Map.of(Month.FEBRUARY, 50), 50)
        );

        Mockito.when(rewardService.calculateRewards()).thenReturn(mockRewards);

        List<RewardResponse> result = rewardController.getAllRewards();

        assertNotNull(result);
        assertEquals(2, result.size(), "Should return rewards for two customers");
    }

    // Validate controller handles null list gracefully
    @Test
    void testGetAllRewards_NullList() {
        Mockito.when(rewardService.calculateRewards()).thenReturn(null);

        List<RewardResponse> result = rewardController.getAllRewards();

        assertNull(result, "Should return null when service returns null");
    }

}
