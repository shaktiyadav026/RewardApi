package com.example.rewardapi.model;

import java.time.LocalDate;

/**
 * Represents a purchase transaction made by a customer.
 */
public class Transaction {

    private String customerId;
    private double amount;
    private LocalDate date;

    public Transaction(String customerId, double amount, LocalDate date) {
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
