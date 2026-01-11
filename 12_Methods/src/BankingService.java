public class BankingService {
    public boolean transferMoney(BankAccount fromAccount, BankAccount toAccount, double amount) {
        double fromBalance = fromAccount.getBalance();
        if(fromBalance >= amount){
            fromAccount.setBalance(fromBalance - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            System.out.println("Transfer successful!");
            return true;
        }
        System.out.println("Insufficient funds!");
        return false;
    }

    public void displayAccountInfo(BankAccount account) {
        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Balance: $" + account.getBalance());
    }
}
