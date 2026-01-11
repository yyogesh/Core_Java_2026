public class BankAccount {
    private String _accountNumber;
    private double _balance;

    public BankAccount(String accountNumber, double balance) {
        this._accountNumber = accountNumber;
        this._balance = balance;
    }

    public double getBalance() {
        return this._balance;
    }

    public void setBalance(double balance) {
        this._balance= balance;
    }

    public String getAccountNumber() {
        return _accountNumber;
    }
}
