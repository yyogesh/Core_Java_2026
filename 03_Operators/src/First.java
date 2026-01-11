import java.util.Scanner;

public class First {
    public static void main(String ar[]){
        int a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two number: ");

        a = scanner.nextInt();
        b = scanner.nextInt();

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        Second.mathFunction();

        byte a1 = 10;
        int i = a1;
        byte b1 = (byte) i;

        IncrementOperator.Increment();
    }
}
