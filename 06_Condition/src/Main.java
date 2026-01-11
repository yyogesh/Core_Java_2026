import java.util.Scanner;

public class Main {
    public static void main(String arg[]){

        System.out.println(FactorialRecursion.factorial(5));
        Scanner sc = new Scanner(System.in);
        int m1, m2, m3;

        System.out.println("Enter marks of 3 subjects:");
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();

        if (m1 < 35 || m2 < 35 || m3 < 35) {
            System.out.println("Result: FAIL (Subject Wise)");
            return;
        }

        // TT
        // FT
        // TF
        // FF==> F

        float avg = (m1 + m2 + m3) / 3.0f;

        System.out.println("Average: " + avg);

        if (avg >= 75)
            System.out.println("Grade: A+ (Distinction)");
        else if (avg >= 60)
            System.out.println("Grade: A");
        else if (avg >= 50)
            System.out.println("Grade: B");
        else if (avg >= 35)
            System.out.println("Grade: C");
        else
            System.out.println("FAIL");
    }
}
