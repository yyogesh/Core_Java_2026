public class ProductManager {
    private Product[] products;
    private int count;

    public ProductManager(int capacity) {
        products = new Product[capacity];
        count = 0;
    }

    public boolean addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
            System.out.println("Product added: " + product.getName());
            return true;
        }

        System.out.println("Inventory  full");
        return false;
    }

    public Product findProductById(String id) {
        for (int i = 0; i < count; i++) {
            if (products[i].getId().equals(id)) {
                return products[i];
            }
        }
        return null;
    }

    public Product[] searchByName(String keyword) {
        Product[] results = new Product[count]; // 50 // 2
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (products[i].getName().toLowerCase().contains(keyword.toLowerCase())) {
                results[resultCount++] = products[i];
            }
        }

        Product[] trimmed = new Product[resultCount];
        System.arraycopy(results, 0, trimmed, 0, resultCount);

        return trimmed;
    }

    public Product[] filterByPriceRange(double minPrice, double maxPrice) {
        Product[] results = new Product[count];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            double price = products[i].getPrice();
            if (price >= minPrice && price <= maxPrice) {
                results[resultCount++] = products[i];
            }
        }

        Product[] trimmed = new Product[resultCount];
        System.arraycopy(results, 0, trimmed, 0, resultCount);
        return trimmed;
    }

    public Product[] filterByCategory(String category) {
        Product[] results = new Product[count];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (products[i].getCategory().equalsIgnoreCase(category)) {
                results[resultCount++] = products[i];
            }
        }

        Product[] trimmed = new Product[resultCount];
        System.arraycopy(results, 0, trimmed, 0, resultCount);
        return trimmed;
    }

    public boolean isAvailable(String productid, int quantity) {
        Product product = findProductById(productid);
        return product != null && product.getStock() >= quantity;
    }

    public boolean purchaseProduct(String productId, int quantity) {
        Product product = findProductById(productId);

        if (product == null) {
            System.out.println("Product not found!");
            return false;
        }

        if (product.getStock() < quantity) {
            System.out.println("Insufficient stock! Available: " + product.getStock());
            return false;
        }

        product.setStock(product.getStock() - quantity);
        System.out.println("Purchase successful! Remaining stock: " + product.getStock());
        return true;
    }

    public void displayAllProducts() {
        System.out.println("\n=== Product Inventory ===");
        for(int i = 0; i < count; i++) {
            System.out.println(products[i]);
        }
    }
}
