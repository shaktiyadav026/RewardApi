package com.rewards.api.repository;

import com.rewards.api.model.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public class InMemoryTransactionRepository implements TransactionRepository {

    private static final List<Transaction> TRANSACTIONS = Arrays.asList(
            new Transaction(1L, LocalDate.of(2024, 3, 15), 120.0),
            new Transaction(1L, LocalDate.of(2024, 2, 10), 80.0),
            new Transaction(2L, LocalDate.of(2024, 3, 12), 130.0),
            new Transaction(3L, LocalDate.of(2024, 1, 5), 220.0)
    );

    @Override
    public List<Transaction> findAllTransactions() {
        return TRANSACTIONS;
    }
}
