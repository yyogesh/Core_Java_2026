import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        demonstrateCheckedExceptions();

        demonstrateUncheckedExceptions();

        ATMMachine atm = new ATMMachine(10000);

        try {
            // SCENARIO 1: Normal successful transaction
            System.out.println("--- SCENARIO 1: Successful Withdrawal ---");
           // atm.insertCard("1234567812345678");
            atm.verifyPin("1234");
            atm.withdrawMoney(2000);

        } catch (CardException | AccountLockedException |
                 InsufficientBalanceException | InvalidAmountException e) {
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            atm.ejectCard();
        }

    }

    public static void demonstrateCheckedExceptions() {
        try {
            // readStudentDataFromFile("students.txt");
        } catch (IOException e) {
            System.out.println("❌ File error: " + e.getMessage());
        }

        try {
            connectToDatabase();
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        }
    }

    public static void demonstrateUncheckedExceptions() {
        System.out.println("\n=== UNCHECKED EXCEPTIONS ===");

        // Example 1: NullPointerException
        String name = null;
        try {
            System.out.println(name.length()); // Will crash!
        } catch (NullPointerException e) {
            System.out.println("❌ Variable is null!");
        }

        int[] marks = {85, 90, 78};
        try {
            System.out.println(marks[5]); // Index doesn't exist!
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("❌ Invalid array index!");
        }

        try {
            int result = 100 / 0; // Division by zero!
            // another line
        } catch (ArithmeticException e) {
            System.out.println("❌ Cannot divide by zero!");
        } catch (Exception ex) {
            System.out.println("Error message");
        }
    }
}

public class ATMMachine {
    private double balance;
    private boolean cardInserted;
    private int wrongPinAttempts;

    public ATMMachine(double initialBalance) {
        this.balance = initialBalance;
        this.cardInserted = false;
        this.wrongPinAttempts = 0;
    }

    public void insertCard(String cardNumber) throws CardException, InvalidCardException {
        if(cardNumber == null || cardNumber.length()  != 16) {
            throw new InvalidCardException("Card number muest be 16 digits");
        }

        if(cardInserted) {
            throw new CardException("Card already inserted!");
        }

        cardInserted = true;
        System.out.println("✓ Card inserted successfully");
    }

    public void ejectCard() {
        cardInserted = false;
        System.out.println("✓ Card ejected. Thank you!");
    }

    public boolean verifyPin(String pin) {

        if (wrongPinAttempts >= 3) {
            try {
                System.out.println("Hello");
                throw new AccountLockedException(
                        "Account locked due to 3 wrong PIN attempts. Contact bank."
                );
            } catch (Exception e) {

            }

        }

        // Simulate PIN verification
        if (!"1234".equals(pin)) {
            wrongPinAttempts++;
            System.out.println("❌ Wrong PIN! Attempts remaining: " +
                    (3 - wrongPinAttempts));
            return false;
        }

        wrongPinAttempts = 0; // Reset on successful login
        System.out.println("✓ PIN verified");
        return true;
    }

    public double checkBalance() throws CardNotInsertedException {
        if (!cardInserted) {
            throw new CardNotInsertedException("Please insert card first!");
        }
        return balance;
    }

}

class CardException extends Exception {
    public CardException(String message) {
        super(message);
    }
}

class InvalidCardException extends Exception {
    public InvalidCardException(String message) {
        super(message);
    }
}

class AccountLockedException extends Exception {
    public AccountLockedException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class CardNotInsertedException extends Exception {
    public CardNotInsertedException(String message) {
        super(message);
    }
}