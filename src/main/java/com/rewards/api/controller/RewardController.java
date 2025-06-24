package com.rewards.api.controller;

import com.rewards.api.model.RewardResponse;
import com.rewards.api.service.RewardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    private final RewardService rewardService;

    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    @GetMapping
    public List<RewardResponse> getAllRewards() {
        return rewardService.calculateRewards();
    }
}
