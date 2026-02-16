public class CreditCardPayment implements PaymentMethod{
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("\n[CREDIT CARD] Processing Payment");
        System.out.println("Card Number: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Amount: $" + amount);
        System.out.println("→ Connecting to bank gateway...");
        System.out.println("→ Validating card with 3D Secure...");
        System.out.println("→ Processing transaction...");
        System.out.println("✓ Credit Card Payment of $" + amount + " Successful!");
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}
