package com.bank.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private List<Account> accounts;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfully for " + name);
    }

    public void displayCustomerInfo() {
        System.out.println("\n=== Customer Information ===");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Total Accounts: " + accounts.size());
    }

    public void displayAllAccounts() {
        System.out.println("\n=== Customer Accounts ===");
        for (Account account : accounts) {
            account.displayAccountInfo();
        }
    }

    // Getters
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public List<Account> getAccounts() { return accounts; }
}
