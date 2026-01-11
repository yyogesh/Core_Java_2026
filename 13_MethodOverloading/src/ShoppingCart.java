public class ShoppingCart {
    // varargs
    public double calculateTotal(double... prices) {
        double total = 0;
        System.out.println("Items in cart: " + prices.length);

        for(double price: prices) {
            total += price;
            System.out.println("Item price: $" + price);
        }

        return total;
    }

    public void addProducts(String category, String... products) {
        System.out.println("\nCategory: " + category);
        System.out.println("Adding products:");
        for (String product : products) {
            System.out.println("- " + product);
        }
    }
}
