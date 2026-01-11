public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234567890", "John Doe", 1000.0);

        account.deposit(500);
        System.out.println("Balance: $" + account.getBalance());
        account.withdraw(200);
        System.out.println("Account: " + account.getAccountNumber());
    }
}
