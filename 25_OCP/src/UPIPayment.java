class UPIPayment implements PaymentMethod {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("\n[UPI] Processing Payment");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount: ₹" + (amount * 83)); // Converting to INR
        System.out.println("→ Connecting to UPI network...");
        System.out.println("→ Sending payment request...");
        System.out.println("→ Waiting for user confirmation...");
        System.out.println("✓ UPI Payment Successful!");
    }

    @Override
    public String getPaymentType() {
        return "UPI";
    }
}