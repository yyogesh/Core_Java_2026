import java.util.Date;

public class Main {
    public static void main(String ar[]){
        int x= 5;
        float y= 10.45f;
        char z= 'B';

        System.out.printf("Hello %d %f %c \n", x, y, z);// D O X

        System.out.printf("%-10s %-10s %-10s%n", "Name", "Age", "Salary");
        System.out.printf("%-10s %-10d %-10.2f%n", "Alice", 25, 45000.5);
        System.out.printf("%-10s %-10d %-10.2f%n", "Bob", 30, 60000.75);


        String item = "Iphone";
        int qty = 2;
        double price = 80000.76;

        String receipt = String.format("Item: %-10s | Qty: %02d | Total: ₹%,.2f", item, qty, qty* price);

        System.out.println(receipt);

        Date d = new Date();

        System.out.printf("Today: %1$td-%1$tm-%1$tY%n", d);

        String card = "1234567812345678";

        System.out.println(String.format("**** **** **** %s", card.substring(card.length() - 4)));

    }
}
