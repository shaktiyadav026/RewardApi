package com.rewards.api.model;

import java.time.Month;
import java.util.Map;

public class RewardResponse {
    private Long customerId;
    private Map<Month, Integer> monthlyRewards;
    private int totalRewards;

    public RewardResponse(Long customerId, Map<Month, Integer> monthlyRewards, int totalRewards) {
        this.customerId = customerId;
        this.monthlyRewards = monthlyRewards;
        this.totalRewards = totalRewards;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Map<Month, Integer> getMonthlyRewards() {
        return monthlyRewards;
    }

    public void setMonthlyRewards(Map<Month, Integer> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }

    public int getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(int totalRewards) {
        this.totalRewards = totalRewards;
    }
}
