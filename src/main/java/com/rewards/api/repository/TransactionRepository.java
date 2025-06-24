package com.rewards.api.repository;

import com.rewards.api.model.Transaction;
import java.util.List;

public interface TransactionRepository {
    List<Transaction> findAllTransactions();
}
