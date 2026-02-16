import com.bank.models.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC-001", 1000.0);
        account.deposit(500);
        account.withdraw(200);

        Greeting g = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };

        g.sayHello();

        Bank.Account a1 = new Bank.Account(101);
        a1.show();

        // Transaction transaction = new Transaction(1);
    }
}


class BankAccount {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public class Transaction {
        private String type;
        private double amount;
        private LocalDateTime timestamp;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.timestamp = LocalDateTime.now();
        }

        public void execute() {
            if (type.equals("DEPOSIT")) {
                balance += amount;
            } else if (type.equals("WITHDRAW")) {
                if (balance >= amount) {
                    balance -= amount;
                } else {
                    System.out.println("Insufficient funds");
                    return;
                }
            }
            transactions.add(this);
            System.out.println(type + " of $" + amount + " completed. New balance: $" + balance);
        }

        @Override
        public String toString() {
            return String.format("%s: $%.2f at %s", type, amount, timestamp);
        }
    }


    public void deposit(double amount) {
        Transaction transaction = new Transaction("DEPOSIT", amount);
        transaction.execute();
    }

    public void withdraw(double amount) {
        Transaction transaction = new Transaction("WITHDRAW", amount);
        transaction.execute();
    }

    public void printStatement() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
        System.out.println("\nTransaction History:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}

interface Greeting {
    void sayHello();
}

class Bank {
    static String bankName = "ABC Bank";

    static class Account {
        int accNo;

        Account(int accNo) {
            this.accNo = accNo;
        }

        void show() {
            System.out.println("Bank: " + bankName);
            System.out.println("Account No: " + accNo);
        }
    }
}

