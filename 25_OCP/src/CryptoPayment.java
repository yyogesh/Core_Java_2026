class CryptoPayment implements PaymentMethod {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("\n[CRYPTOCURRENCY] Processing Payment");
        System.out.println("Wallet: " + walletAddress.substring(0, 10) + "...");
        System.out.println("Amount: $" + amount);
        System.out.println("→ Connecting to blockchain network...");
        System.out.println("→ Broadcasting transaction...");
        System.out.println("→ Waiting for confirmations...");
        System.out.println("✓ Crypto Payment of $" + amount + " Successful!");
    }

    @Override
    public String getPaymentType() {
        return "Cryptocurrency";
    }
}