package com.example.rewardapi.service;

import com.example.rewardapi.exception.CustomerNotFoundException;
import com.example.rewardapi.model.RewardResponse;
import com.example.rewardapi.model.Transaction;
import com.example.rewardapi.util.RewardCalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class to process transactions and calculate reward points.
 */
@Service
public class RewardService {

    // Mock data - In a real app, this would come from a database
    private static final List<Transaction> transactions = List.of(
            new Transaction("C1", 120.0, LocalDate.of(2024, 1, 15)),
            new Transaction("C1", 75.0, LocalDate.of(2024, 1, 25)),
            new Transaction("C1", 110.0, LocalDate.of(2024, 2, 10)),
            new Transaction("C2", 95.0, LocalDate.of(2024, 1, 5)),
            new Transaction("C2", 200.0, LocalDate.of(2024, 2, 20)),
            new Transaction("C2", 130.0, LocalDate.of(2024, 3, 15)),
            new Transaction("C3", 40.0, LocalDate.of(2024, 2, 15))
    );

    /**
     * Calculates reward points for the given customer based on past transactions.
     *
     * @param customerId ID of the customer
     * @return RewardResponse with monthly and total points
     */
    public RewardResponse calculateRewards(String customerId) {
        // Filter transactions for the given customer
        List<Transaction> customerTxns = transactions.stream()
                .filter(t -> t.getCustomerId().equalsIgnoreCase(customerId))
                .collect(Collectors.toList());

        if (customerTxns.isEmpty()) {
            throw new CustomerNotFoundException(customerId);
        }

        Map<String, Integer> monthlyPoints = new HashMap<>();
        int totalPoints = 0;

        for (Transaction txn : customerTxns) {
            int points = RewardCalculator.calculatePoints(txn.getAmount());
            String month = RewardCalculator.getMonthName(txn.getDate());

            monthlyPoints.merge(month, points, Integer::sum);
            totalPoints += points;
        }

        return new RewardResponse(customerId, monthlyPoints, totalPoints);
    }
}
