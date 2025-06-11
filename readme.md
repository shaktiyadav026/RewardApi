# Rewards API

A Spring Boot RESTful Web API that simulates a **retailer rewards program** based on customer transactions.

---

## 🧾 Problem Statement

A retailer wants to implement a rewards program:

- Customers earn **2 points** for every dollar spent **over $100**.
- They also earn **1 point** for every dollar spent **between $50 and $100**.
- No points for purchases **$50 or less**.

> For example: a $120 purchase → 2×$20 + 1×$50 = **90 points**

The system calculates reward points **per customer**, broken down **monthly** and in **total**, based on a transaction history.

---

## 🚀 Tech Stack

- Java 17+
- Spring Boot 3.x
- RESTful API
- JUnit 5 (unit + integration tests)

---

## 📁 Project Structure

```text
com.example.rewardapi
├── controller       # REST endpoint
├── exception        # Custom exceptions and handler
├── model            # DTOs (Transaction, RewardResponse)
├── service          # Business logic for reward calculation
├── util             # Utility for reward points and month formatting
└── RewardapiApplication.java  # Main Spring Boot class
