package com.rewards.api.model;

import java.time.LocalDate;

public class Transaction {
    private Long customerId;
    private LocalDate date;
    private double amount;

    public Transaction() {}

    public Transaction(Long customerId, LocalDate date, double amount) {
        this.customerId = customerId;
        this.date = date;
        this.amount = amount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
