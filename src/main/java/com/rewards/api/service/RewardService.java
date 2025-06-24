package com.rewards.api.service;

import com.rewards.api.model.Transaction;
import com.rewards.api.repository.TransactionRepository;
import com.rewards.api.model.RewardResponse;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;

@Service
public class RewardService {

    private final TransactionRepository transactionRepository;

    public RewardService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<RewardResponse> calculateRewards() {
        List<Transaction> transactions = transactionRepository.findAllTransactions();

        Map<Long, Map<Month, Integer>> monthlyRewards = new HashMap<>();
        Map<Long, Integer> totalRewards = new HashMap<>();

        for (Transaction tx : transactions) {
            Long customerId = tx.getCustomerId();
            Month month = tx.getDate().getMonth();
            int points = calculatePoints(tx.getAmount());

            monthlyRewards.computeIfAbsent(customerId, k -> new HashMap<>());
            monthlyRewards.get(customerId).merge(month, points, Integer::sum);
            totalRewards.merge(customerId, points, Integer::sum);
        }

        List<RewardResponse> response = new ArrayList<>();
        for (Long customerId : totalRewards.keySet()) {
            Map<Month, Integer> monthly = monthlyRewards.getOrDefault(customerId, Collections.emptyMap());
            response.add(new RewardResponse(customerId, monthly, totalRewards.get(customerId)));
        }

        return response;
    }

    private int calculatePoints(double amount) {
        int points = 0;
        if (amount > 100) points += (int)((amount - 100) * 2) + 50;
        else if (amount > 50) points += (int)(amount - 50);
        return points;
    }
}
