public class Main {
    public static void main(String[] ar) {

        BankAccount account1 = new BankAccount("ACC001", 5000);
        BankAccount account2 = new BankAccount("ACC002", 2000);

        BankingService service = new BankingService();

        service.displayAccountInfo(account1);
        service.displayAccountInfo(account2);

        service.transferMoney(account1, account2, 1000);
        System.out.println("\nAfter Transfer:");
        service.displayAccountInfo(account1);
        service.displayAccountInfo(account2);


        Main main = new Main();
        int result =  main.add(10, 5);
       // main.add(20, 5);
        double finalPrice= main.calculateFinalPrice(1000, 10);
        System.out.println("Final Price: $" + finalPrice);

        System.out.println("Order Valid ::" + main.isOrderValid(1, 1000));
        main.printOrderConfirmation("ORD12345", finalPrice);
    }

    public double calculateFinalPrice(double originalPrice, double discountPercent) {
        double discountAmount = originalPrice * (discountPercent/ 100);
        return originalPrice - discountAmount;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public boolean isOrderValid(int quantity, double price) {
        return quantity > 0 && price > 0;
    }

    public void printOrderConfirmation(String orderId, double amount) {
        System.out.println("Order ID: " + orderId);
        System.out.println("Total Amount: $" + amount);
        System.out.println("Thank you for your purchase!");
    }
}
