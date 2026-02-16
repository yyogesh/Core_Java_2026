public class Main {
    public static void main(String[] args) {
        PaymentProcessorGood goodProcessor = new PaymentProcessorGood();
        PaymentMethod creditCard = new CreditCardPayment("1234567812345678");
        goodProcessor.processPayment(creditCard, 100.00);

        PaymentMethod paypal = new PayPalPayment("user@example.com");
        goodProcessor.processPayment(paypal, 250.00);

        PaymentMethod crypto = new CryptoPayment("0x742d35Cc6634C0532925a3b844Bc9e7595f0bEb");
        goodProcessor.processPayment(crypto, 500.00);
    }
}

class PaymentProcessorGood {

    public void processPayment(PaymentMethod paymentMethod, double amount) {
        System.out.println("═".repeat(50));
        System.out.println("INITIATING PAYMENT");
        System.out.println("Payment Type: " + paymentMethod.getPaymentType());
        System.out.println("═".repeat(50));

        // Process using the specific payment method
        paymentMethod.processPayment(amount);

        // Common post-processing (works for ALL payment types)
        sendReceipt(amount, paymentMethod.getPaymentType());
        updateInventory();
    }

    private void sendReceipt(double amount, String paymentType) {
        System.out.println("\n📧 Sending receipt...");
        System.out.println("   Payment Type: " + paymentType);
        System.out.println("   Amount Paid: $" + amount);
        System.out.println("   Receipt sent to email!");
    }

    private void updateInventory() {
        System.out.println("\n📦 Updating inventory...");
        System.out.println("   Stock updated successfully!");
    }
}


class PaymentProcessorBad {

    public void processPayment(String paymentType, double amount) {

        if (paymentType.equals("CREDIT_CARD")) {
            System.out.println("Processing Credit Card Payment...");
            System.out.println("Amount: $" + amount);
            System.out.println("Connecting to bank gateway...");
            System.out.println("Validating card number...");
            System.out.println("✓ Credit Card Payment Successful!");

        } else if (paymentType.equals("DEBIT_CARD")) {
            System.out.println("Processing Debit Card Payment...");
            System.out.println("Amount: $" + amount);
            System.out.println("Checking account balance...");
            System.out.println("Deducting from account...");
            System.out.println("✓ Debit Card Payment Successful!");

        } else if (paymentType.equals("PAYPAL")) {
            System.out.println("Processing PayPal Payment...");
            System.out.println("Amount: $" + amount);
            System.out.println("Redirecting to PayPal...");
            System.out.println("Authenticating user...");
            System.out.println("✓ PayPal Payment Successful!");

        } else if (paymentType.equals("CRYPTO")) {
            System.out.println("Processing Cryptocurrency Payment...");
            System.out.println("Amount: $" + amount);
            System.out.println("Connecting to blockchain...");
            System.out.println("Confirming transaction...");
            System.out.println("✓ Crypto Payment Successful!");

        } else {
            System.out.println("❌ Unknown payment type: " + paymentType);
        }
    }

}