package com.rewards.api.service;

import com.rewards.api.model.RewardResponse;
import com.rewards.api.model.Transaction;
import com.rewards.api.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RewardServiceTest {

    private final TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);
    private final RewardService rewardService = new RewardService(transactionRepository);

    // Validate reward points are calculated correctly for provided transactions
    @Test
    void testCalculateRewards_Positive() {
        List<Transaction> mockTransactions = Arrays.asList(
                new Transaction(1L, LocalDate.of(2024, 3, 10), 120.0),
                new Transaction(1L, LocalDate.of(2024, 2, 15), 80.0)
        );

        Mockito.when(transactionRepository.findAllTransactions()).thenReturn(mockTransactions);

        List<RewardResponse> result = rewardService.calculateRewards();

        assertNotNull(result);
        assertFalse(result.isEmpty(), "Reward response should not be empty");
        assertEquals(1, result.size(), "One customer reward record expected");
    }

    // Validate empty transaction list returns empty rewards response
    @Test
    void testCalculateRewards_EmptyTransactionList() {
        Mockito.when(transactionRepository.findAllTransactions()).thenReturn(List.of());

        List<RewardResponse> result = rewardService.calculateRewards();

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Reward response should be empty when no transactions");
    }

    // Validate rewards calculated for multiple customers
    @Test
    void testCalculateRewards_MultipleCustomers() {
        List<Transaction> mockTransactions = Arrays.asList(
                new Transaction(1L, LocalDate.of(2024, 3, 10), 120.0),
                new Transaction(2L, LocalDate.of(2024, 2, 15), 90.0)
        );

        Mockito.when(transactionRepository.findAllTransactions()).thenReturn(mockTransactions);

        List<RewardResponse> result = rewardService.calculateRewards();

        assertNotNull(result);
        assertEquals(2, result.size(), "Should calculate rewards for two customers");
    }

}
