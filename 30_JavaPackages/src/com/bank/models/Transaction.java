package com.bank.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private String transactionType; // DEPOSIT, WITHDRAW, TRANSFER
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String transactionId, String accountNumber,
                       String transactionType, double amount) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public void displayTransaction() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Account: " + accountNumber);
        System.out.println("Type: " + transactionType);
        System.out.println("Amount: $" + amount);
        System.out.println("Date: " + timestamp.format(formatter));
        System.out.println("------------------------");
    }

    // Getters
    public String getTransactionId() { return transactionId; }
    public String getTransactionType() { return transactionType; }
    public double getAmount() { return amount; }
}