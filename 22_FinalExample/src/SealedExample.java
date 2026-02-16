public class SealedExample {
}

sealed interface Vehicle permits Car, Bike, Truck {
    void start();
    void stop();
}

final class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car engine starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car engine stopping...");
    }
}

non-sealed class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopping...");
    }
}

sealed class Truck implements Vehicle permits DeliveryTruck{
    @Override
    public void start() {
        System.out.println("Truck starting...");
    }

    @Override
    public void stop() {
        System.out.println("Truck stopping...");
    }
}

final class DeliveryTruck extends Truck {
    void deliverPackage() {
        System.out.println("Delivering package");
    }
}

class ElectricBike extends Bike {
    @Override
    public void start() {
        System.out.println("Electric bike starting silently...");
    }
}