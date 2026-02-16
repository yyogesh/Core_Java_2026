package com.bank.main;

//import com.bank.models.Account;
//import com.bank.models.Customer;
import com.bank.models.*;
//import com.bank.services.BankService;
import com.bank.utils.ValidationUtils;

public class BankingApp {
    public static void main(String[] args) {
        System.out.println("=== Banking System Started ===\n");

        // Create customer
        Customer customer1 = new Customer(
                "CUST001",
                "John Doe",
                "john.doe@email.com",
                "9876543210"
        );

        // Validate email
        if (ValidationUtils.isValidEmail(customer1.getName())) {
            System.out.println("Valid email!");
        }

        // Create accounts
        Account savingsAccount = new Account("ACC100001", "John Doe", 5000.0);
        Account currentAccount = new Account("ACC100002", "John Doe", 10000.0);

        // Add accounts to customer
        customer1.addAccount(savingsAccount);
        customer1.addAccount(currentAccount);

        // Display customer info
        customer1.displayCustomerInfo();
        customer1.displayAllAccounts();

        // Create banking service
        com.bank.services.BankService bankService = new com.bank.services.BankService();

        // Perform transactions
        System.out.println("\n=== Performing Transactions ===");

        bankService.deposit(savingsAccount, 2000);
        System.out.println();

        bankService.withdraw(savingsAccount, 1000);
        System.out.println();

        bankService.transfer(currentAccount, savingsAccount, 3000);
        System.out.println();

        // Display updated account info
        customer1.displayAllAccounts();

        // Display transaction history
        bankService.displayTransactionHistory();

        // Test validation utilities
        System.out.println("\n=== Testing Validation Utils ===");
        System.out.println("Valid Email (john@email.com): " +
                ValidationUtils.isValidEmail("john@email.com"));
        System.out.println("Invalid Email (john.email): " +
                ValidationUtils.isValidEmail("john.email"));
        System.out.println("Valid Phone (9876543210): " +
                ValidationUtils.isValidPhone("9876543210"));
        System.out.println("Invalid Phone (123): " +
                ValidationUtils.isValidPhone("123"));
        System.out.println("Formatted Amount: " +
                ValidationUtils.formatCurrency(15000.5));
    }
}