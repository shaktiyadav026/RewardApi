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

✅ Project Overview
The Rewards API is a Spring Boot-based RESTful Web API that calculates reward points for customers based on their transactions over the past three months.

This project:

Calculates monthly and total reward points per customer.

Provides APIs to retrieve customer information and rewards data.

Uses mock data in the repository layer to simulate a real database.



## 🚀 Tech Stack

Java 17

Spring Boot 3.x

REST API

JUnit 5

Mockito

Maven

---

## 📁 Project Structure

```text
com.rewards.api
│
├── controller
│   ├── CustomerController.java        // Customer REST endpoints
│   └── RewardController.java          // Rewards REST endpoints
│
├── service
│   ├── CustomerService.java           // Customer business logic
│   └── RewardService.java             // Rewards calculation logic
│
├── repository
│   ├── CustomerRepository.java        // Provides mock customer data
│   └── TransactionRepository.java     // Provides mock transaction data
│
├── model
│   ├── Customer.java                  // Customer entity
│   ├── Transaction.java               // Transaction entity
│   └── RewardResponse.java            // Rewards response structure
│
├── RewardsApiApplication.java         // Spring Boot main class



✅ API Endpoints
🔹 Fetch All Customers
GET /api/customers
Returns a list of all customers.

Example Response:

json

[
    { "customerId": 1, "customerName": "John Doe" },
    { "customerId": 2, "customerName": "Jane Smith" }
]
🔹 Fetch All Rewards

GET /api/rewards
Returns calculated rewards for all customers, broken down by month and total.

Example Response:

Edit
[
    {
        "customerId": 1,
        "rewardsPerMonth": { "MARCH": 90, "FEBRUARY": 50 },
        "totalRewards": 140
    }
]


