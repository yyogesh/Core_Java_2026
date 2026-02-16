class DebitCardPayment implements PaymentMethod {
    private String accountNumber;

    public DebitCardPayment(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("\n[DEBIT CARD] Processing Payment");
        System.out.println("Account: ****" + accountNumber.substring(accountNumber.length() - 4));
        System.out.println("Amount: $" + amount);
        System.out.println("→ Checking account balance...");
        System.out.println("→ Deducting from account...");
        System.out.println("→ Updating balance...");
        System.out.println("✓ Debit Card Payment of $" + amount + " Successful!");
    }

    @Override
    public String getPaymentType() {
        return "Debit Card";
    }
}