public class Main {
    public static void main(String[] args) {
        SmartPhone myPhone= new SmartPhone();
        myPhone.brand = "Apple";
        myPhone.batteryPercentage = 50;
        myPhone.isOn = true;

        SmartPhone yourPhone = new SmartPhone(); // Object 2
        yourPhone.brand = "Samsung";
        yourPhone.batteryPercentage = 80;
    }
}


class SmartPhone {
    String brand;
    String Model;
    int batteryPercentage;
    double price;
    boolean isOn;

    void makeCall(String number) {
        if (isOn && batteryPercentage > 5) {
            System.out.println("Calling " + number);
            batteryPercentage -= 2;
        } else {
            System.out.println("Cannot make call");
        }
    }

    void charge(int minutes) {
        batteryPercentage = Math.min(100, batteryPercentage + (minutes / 2));
        System.out.println("Battery: " + batteryPercentage + "%");
    }
}