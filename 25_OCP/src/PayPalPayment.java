class PayPalPayment implements PaymentMethod {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("\n[PAYPAL] Processing Payment");
        System.out.println("PayPal Email: " + email);
        System.out.println("Amount: $" + amount);
        System.out.println("→ Redirecting to PayPal...");
        System.out.println("→ Authenticating user...");
        System.out.println("→ Confirming transaction...");
        System.out.println("✓ PayPal Payment of $" + amount + " Successful!");
    }

    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}
