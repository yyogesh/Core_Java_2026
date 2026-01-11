public class Main {
    public static void main(String[] args) {
        Product p = new Product("P001", "Generic Item", 100.0, 50);
        p.displayInfo();
        System.out.println("Discount: $" + p.calculateDiscount());

        // IS - A

        Electronics e = new Electronics(
                "E001",
                "Smart TV",
                1200.0,
                10,
                "Samsung",
                24
        );

        e.displayInfo();
        System.out.println("Discount: $" + e.calculateDiscount());

        Laptop l = new Laptop(
                "L001",
                "Gaming Laptop",
                2000.0,
                5,
                "Dell",
                36,
                "Intel i7",
                16,
                "Windows 11"
        );

        l.displayInfo();
        System.out.println("Discount: $" + l.calculateDiscount());
        System.out.println("Is gaming capable? " + l.isGamingCapable());
    }
}

class Product {
    protected String productId;
    protected String name;
    protected double price;
    protected int stockQuantity;

    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stock;
    }

    public double calculateDiscount() {
        return 0; // No discount by default
    }

    public void displayInfo() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stockQuantity);
    }
}

class Electronics extends Product {
    private int warrantyMonths;
    private String brand;

    public Electronics(String id, String name, double price, int stock,
                       String brand, int warranty) {
        super(id, name, price, stock);
        this.brand = brand;
        this.warrantyMonths = warranty;
    }

    @Override
    public double calculateDiscount() {
        // Electronics get 10% discount
        return price * 0.10;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warrantyMonths + " months");
    }
}

// Multilevel Inheritance
class Laptop extends Electronics {
    private String processor;
    private int ramGB;
    private String operatingSystem;

    public Laptop(String id, String name, double price, int stock,
                  String brand, int warranty, String processor, int ram, String os) {
        super(id, name, price, stock, brand, warranty);
        this.processor = processor;
        this.ramGB = ram;
        this.operatingSystem = os;
    }

    @Override
    public double calculateDiscount() {
        // Laptops get 15% discount
        return price * 0.15;
    }

    public boolean isGamingCapable() {
        return ramGB >= 16 && processor.contains("i7");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Processor: " + processor);
        System.out.println("RAM: " + ramGB + "GB");
        System.out.println("OS: " + operatingSystem);
        System.out.println("Gaming Capable: " + isGamingCapable());
    }
}

class Clothing extends Product {
    private String size;
    private String color;
    private String material;

    public Clothing(String id, String name, double price, int stock,
                    String size, String color, String material) {
        super(id, name, price, stock);
        this.size = size;
        this.color = color;
        this.material = material;
    }

    @Override
    public double calculateDiscount() {
        // Clothing gets 20% discount
        return price * 0.20;
    }
}

//class Mobile extends Electronics, Product {
//
//}

// interface

//interface A {
//}
//interface B extends A {
//}
//class C implements B {
//}
