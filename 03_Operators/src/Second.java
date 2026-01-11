import java.util.Scanner;

public class Second {
    public static void mathFunction() {
        double a, b, c;
        Scanner  scanner = new Scanner(System.in);
        double d, root1, root2;

        System.out.println("Enter coefficients a, b, c:");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();

        d = b * b - 4 * a * c;

        root1 = (-b + Math.sqrt(d)) / (2 * a);
        root2 = (-b - Math.sqrt(d)) / (2 * a);

        System.out.println("Root 1 = " + root1);
        System.out.println("Root 2 = " + root2);
    }
}
