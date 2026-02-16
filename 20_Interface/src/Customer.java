
interface Persistable {
}
interface Auditable {
}

class Customer implements Persistable, Auditable {
    private String name;
    private String email;
    private double balance;

    public Customer(String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class DataManager {
    public void save(Object obj) {
        if(obj instanceof Persistable) {
            System.out.println("Saving " + obj.getClass().getSimpleName() + " to database");
        } else {
            System.out.println("Cannot save: " + obj.getClass().getSimpleName() + " is not Persistable");
        }
    }
}
