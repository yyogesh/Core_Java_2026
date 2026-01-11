public class BankAccount {
    // Private data - hidden from outside world
    private double balance;
    private String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountNumber, String name, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = name;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount");
            return false;
        }
    }

    // Getter - read-only access to balance
    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        // Masking for security
        return "****" + accountNumber.substring(accountNumber.length() - 4);
    }
}

class BankAccountBad {
    public double balance;
    public String accountNumber;
}
