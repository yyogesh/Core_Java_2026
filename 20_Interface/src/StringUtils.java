public interface StringUtils {
    static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    static String capitalize(String str) {
        if (isEmpty(str)) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    static String reverse(String str) {
        if (isEmpty(str)) return str;
        return new StringBuilder(str).reverse().toString();
    }
}

interface VehicleFactory {
    static Vehicle createCar(String model) {
        return new Vehicle("Car", model);
    }

    static Vehicle createTruck(String model) {
        return new Vehicle("Truck", model);
    }

    static Vehicle createMotorcycle(String model) {
        return new Vehicle("Motorcycle", model);
    }
}

class Vehicle {
    private String type;
    private String model;

    public Vehicle(String type, String model) {
        this.type = type;
        this.model = model;
    }

    public void display() {
        System.out.println("Vehicle Type: " + type + ", Model: " + model);
    }
}


