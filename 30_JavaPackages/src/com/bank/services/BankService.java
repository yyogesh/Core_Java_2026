package com.bank.services;

import com.bank.models.Account;
import com.bank.models.Transaction;
import java.util.ArrayList;
import java.util.List;

public class BankService {
    private List<Transaction> transactionHistory;

    public BankService() {
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount for deposit!");
            return;
        }

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);

        // Record transaction
        Transaction transaction = new Transaction(
                "TXN" + System.currentTimeMillis(),
                account.getAccountNumber(),
                "DEPOSIT",
                amount
        );
        transactionHistory.add(transaction);

        System.out.println("Deposited $" + amount + " successfully!");
        System.out.println("New Balance: $" + account.getBalance());
    }

    public void withdraw(Account account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount for withdrawal!");
            return;
        }

        if (account.getBalance() < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);

        // Record transaction
        Transaction transaction = new Transaction(
                "TXN" + System.currentTimeMillis(),
                account.getAccountNumber(),
                "WITHDRAW",
                amount
        );
        transactionHistory.add(transaction);

        System.out.println("Withdrawn $" + amount + " successfully!");
        System.out.println("New Balance: $" + account.getBalance());
    }

    public void transfer(Account fromAccount, Account toAccount, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount for transfer!");
            return;
        }

        if (fromAccount.getBalance() < amount) {
            System.out.println("Insufficient balance for transfer!");
            return;
        }

        // Withdraw from source
        withdraw(fromAccount, amount);

        // Deposit to destination
        deposit(toAccount, amount);

        System.out.println("Transfer completed successfully!");
    }

    public void displayTransactionHistory() {
        System.out.println("\n=== Transaction History ===");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactionHistory) {
            transaction.displayTransaction();
        }
    }
}