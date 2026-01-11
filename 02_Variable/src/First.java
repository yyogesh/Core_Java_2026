import java.util.Scanner;

public class First {
    public static void main(String a1[]) {
        System.out.println("Hello Java");

        int x = 100;
        boolean y = false;
        // System.out.println(a1[0]);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name::");
        String result = scanner.next();
        System.out.println(result + " " +  x);

        // integral => byte, short, int, long
        // -128 to 127
        // 8 bit 16 bit 32 bit 64 bit
        // floating point  ==> float double
        // char (2)
        // boolean

        System.out.println(Byte.MIN_VALUE);

        long z = 100L;
        float f = 10.5F;
        double d = 20.1D;

        long Z = 10;

        long Z1$_1 = 10;

        long long1 = 10;

        int x112333333333333333333333333333333333333333333333 = 10;

        String firstNameOfEmployee = "test"; // camel case

        // Literals

        long k = 999_999_98;

        System.out.println(Integer.toBinaryString(x));

        char x1 = 0x0380;
        System.out.println(x1);

        for(char c = 0x0900; c<=0x0970; c++){
            System.out.print(c+ " ");
        }

    }
}

//First first = new First();
//First.main()
// Void no return

// Javac First.java

// java First all


