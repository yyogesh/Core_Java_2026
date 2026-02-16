package com.bank.utils;

public class ValidationUtils {

    // Validate email format
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }

    // Validate phone number (10 digits)
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        return phone.matches("\\d{10}");
    }

    // Validate account number
    public static boolean isValidAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return false;
        }
        return accountNumber.matches("ACC\\d{6}"); // Format: ACC123456
    }

    // Format currency
    public static String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }

    // Validate positive amount
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }
}