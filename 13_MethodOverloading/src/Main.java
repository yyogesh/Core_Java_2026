import java.io.File;

public class Main {
    public static void main(String[] ar) {
        NotificationService notificationService = new NotificationService();

        notificationService.sendNotification("user@example.com", "Your order is confirmed");
        notificationService.sendNotification(9876543210L, "OTP is 1234");
        notificationService.sendNotification("admin@example.com", "Server down!", "HIGH");

        String[] subscribers = {"user1@test.com", "user2@test.com"};
        notificationService.sendNotification(subscribers, "Newsletter for January");

        ShoppingCart cart = new ShoppingCart();

        double total = cart.calculateTotal(25.99, 15.50, 30.00, 99);
        System.out.println("Total: $" + total);

        double total2 = cart.calculateTotal(100.00);
        System.out.println("Total: $" + total2);

        cart.addProducts("Electronics", "Laptop", "Mouse", "Keyboard", "Monitor");

        int x = factorial(5);
        System.out.println(sumOfDigits(87465));

        listFiles(new File("/src"), 1);

    }

    static int factorial(int n){
        if(n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int sumOfDigits(int number) { ///  87465
        if(number == 0) {
            return 0;
        }
       return number % 10 + sumOfDigits(number / 10); // 5 // 8746

    }

    // folder // folder // folder // file

    public static void listFiles(File directory, int level) {
        if(!directory.exists() || !directory.isDirectory()) {
            return;
        }

        String indent = "  ".repeat(level);
        System.out.println(indent  + "[DIR]" + directory.getName()); //  [DIR] - txt.doc

        File[] files = directory.listFiles(); // get all the files
        if(files != null) {
            for(File file: files) {
                if(file.isDirectory()) {
                    listFiles(file, level + 1);
                } else {
                    System.out.println(indent + " - " + file.getName());
                }
            }
        }
    }

}
