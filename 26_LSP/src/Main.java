public class Main {
    public static void main(String[] args) {
        // the Liskov Substitution principle
        // parent ===> child
        SavingsAccount savings = new SavingsAccount("SAV001", 1000);
        CurrentAccount current = new CurrentAccount("CUR001", 2000, 1000);
        FixedDepositAccount fd = new FixedDepositAccount("FD001", 5000, 12);


        BankingService service = new BankingService();

        Account[] allAccounts = {savings, current, fd};
        service.displayAllAccountsInfo(allAccounts);

        service.processWithdrawal(savings, 200);
        service.processWithdrawal(current, 2500);

        savings.applyInterest();
    }
}

class BankAccountBad {
    protected double balance;
    protected String accountNumber;

    public BankAccountBad(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " | Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " | Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }
}


class FixedDepositAccountBad extends BankAccountBad {
    public FixedDepositAccountBad(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
      // Violates LSP
    }
}


interface Account {
    String getAccountNumber();
    double getBalance();
    void displayAccountInfo();
}

interface Depositable {
    void deposit(double amount);
}

interface Withdrawable {
    void withdraw(double amount);
}


class SavingsAccount implements Account, Depositable, Withdrawable {
    private String accountNumber;
    private double balance;
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.interestRate = 3.5; // 3.5% interest
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid deposit amount!");
            return;
        }
        balance += amount;
        System.out.println("✓ [SAVINGS] Deposited $" + amount);
        System.out.println("  New Balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
            return;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("✓ [SAVINGS] Withdrew $" + amount);
            System.out.println("  New Balance: $" + balance);
        } else {
            System.out.println("❌ [SAVINGS] Insufficient funds!");
            System.out.println("  Available: $" + balance + " | Requested: $" + amount);
        }
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("✓ [SAVINGS] Interest Applied: $" + interest);
        System.out.println("  New Balance: $" + balance);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│     SAVINGS ACCOUNT DETAILS         │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ Account Number: " + accountNumber);
        System.out.println("│ Balance: $" + String.format("%.2f", balance));
        System.out.println("│ Interest Rate: " + interestRate + "%");
        System.out.println("└─────────────────────────────────────┘");
    }
}

class FixedDepositAccount implements Account {
    private String accountNumber;
    private double balance;
    private int tenureMonths;
    private double interestRate;

    public FixedDepositAccount(String accountNumber, double amount, int tenureMonths) {
        this.accountNumber = accountNumber;
        this.balance = amount;
        this.tenureMonths = tenureMonths;
        this.interestRate = 7.5; // 7.5% interest for FD
    }

    public double calculateMaturityAmount() {
        double interest = balance * (interestRate / 100) * (tenureMonths / 12.0);
        return balance + interest;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│  FIXED DEPOSIT ACCOUNT DETAILS      │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ Account Number: " + accountNumber);
        System.out.println("│ Principal: $" + String.format("%.2f", balance));
        System.out.println("│ Tenure: " + tenureMonths + " months");
        System.out.println("│ Interest Rate: " + interestRate + "%");
        System.out.println("│ Maturity Amount: $" + String.format("%.2f", calculateMaturityAmount()));
        System.out.println("└─────────────────────────────────────┘");
    }
}

class CurrentAccount implements Account, Depositable, Withdrawable {
    private String accountNumber;
    private double balance;
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid deposit amount!");
            return;
        }
        balance += amount;
        System.out.println("✓ [CURRENT] Deposited $" + amount);
        System.out.println("  New Balance: $" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
            return;
        }
        double availableBalance = balance + overdraftLimit;
        if (availableBalance >= amount) {
            balance -= amount;
            System.out.println("✓ [CURRENT] Withdrew $" + amount);
            System.out.println("  New Balance: $" + balance);
            if (balance < 0) {
                System.out.println("  ⚠️ Using overdraft: $" + Math.abs(balance));
            }
        } else {
            System.out.println("❌ [CURRENT] Insufficient funds including overdraft!");
            System.out.println("  Available: $" + availableBalance + " | Requested: $" + amount);
        }
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│     CURRENT ACCOUNT DETAILS         │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ Account Number: " + accountNumber);
        System.out.println("│ Balance: $" + String.format("%.2f", balance));
        System.out.println("│ Overdraft Limit: $" + overdraftLimit);
        System.out.println("└─────────────────────────────────────┘");
    }
}

class BankingService {
    public void displayAllAccountsInfo(Account[] accounts) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DISPLAYING ALL ACCOUNTS");
        System.out.println("=".repeat(50));

        for (Account account : accounts) {
            account.displayAccountInfo();
        }
    }

    public void processWithdrawal(Withdrawable account, double amount) {
        System.out.println("\n--- Processing Withdrawal ---");
        account.withdraw(amount);
    }

    public void processDeposit(Depositable account, double amount) {
        System.out.println("\n--- Processing Deposit ---");
        account.deposit(amount);
    }
}
