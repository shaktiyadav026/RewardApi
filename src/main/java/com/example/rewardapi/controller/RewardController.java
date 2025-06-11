package com.example.rewardapi.controller;

import com.example.rewardapi.model.RewardResponse;
import com.example.rewardapi.service.RewardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller that exposes endpoints to retrieve reward points per customer.
 */
@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    /**
     * Returns the reward summary for a specific customer.
     *
     * @param customerId Customer ID to fetch rewards for
     * @return ResponseEntity with RewardResponse
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<RewardResponse> getRewards(@PathVariable String customerId) {
        RewardResponse response = rewardService.calculateRewards(customerId);
        return ResponseEntity.ok(response);
    }
}
