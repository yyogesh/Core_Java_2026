public class Main {
    public static void main(String[] ar) {
        ProductManager manager = new ProductManager(20);

        manager.addProduct(new Product("P001", "Laptop", 899.99, 15, "Electronics"));
        manager.addProduct(new Product("P002", "Mouse", 29.99, 50, "Electronics"));
        manager.addProduct(new Product("P003", "Keyboard", 79.99, 30, "Electronics"));
        manager.addProduct(new Product("P004", "Chair", 199.99, 8, "Furniture"));
        manager.addProduct(new Product("P005", "Desk", 349.99, 5, "Furniture"));
        manager.addProduct(new Product("P006", "Monitor", 299.99, 12, "Electronics"));

        manager.displayAllProducts();
        System.out.println("\n=== Search Results for 'lap' ===");
        Product[] searchResults = manager.searchByName("lap");

        for(Product p: searchResults) {
            System.out.println(p);
        }
    }
}
