public class Main {
    final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";

    static final int MAX_CONNECTIONS = 100;
    static final double PI = 3.14159;

    final int userId;

    Main(int id) {
        this.userId = id;
        // userId = 10;
    }

    public static void main(String[] args) {
        // const
        // final
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
    }
}

class BankAccount {
    protected double balance;

    public final void validateTransaction(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public void withdraw(double amount) {
        validateTransaction(amount);
        balance -= amount;
    }
}

class SavingAccount extends BankAccount {
//    @Override
//    public final void validateTransaction(double amount) {
//
//    }
    @Override
    public void withdraw(double amount) {
        validateTransaction(amount);
        balance -= amount;
        System.out.println("Withdrawal from savings account");
    }
}

final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}

class Employee extends ImmutablePerson {

}
