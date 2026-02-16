public interface PaymentGateway {
    void processPayment(double amount);

    default void refundPayment(double amount) {
        System.out.println("Processing refund of $" + amount);
        System.out.println("Default refund mechanism used");
    }

    default void generateReceipt(double amount) {
        System.out.println("===== RECEIPT =====");
        System.out.println("Amount: $" + amount);
        System.out.println("==================");
    }
}


class StripePayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {

    }

    @Override
    public void refundPayment(double amount) {
        PaymentGateway.super.refundPayment(amount);
    }
}