public class Main {
    public static void main(String str[]) {
        for(int i =1; i <= 5; i++) {
            System.out.println("value of i is:: " + i);
        }
        int n = 5;
        for(int i = 1; i <=n; i++) {
            for(int s = i; s < n; s++) {
                System.out.print(" ");
            }
            // System.out.println(2* i -1);
            for(int j =1; j<=(2* i -1); j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = n-1; i >= 1; i--) {
            for(int s = n; s > i; s--) {
                System.out.print(" ");
            }
            // System.out.println(2* i -1);
            for(int j =1; j<=(2* i -1); j++){
                System.out.print("*");
            }
            System.out.println();
        }

        int n1 = 5;
        long fact= 1;

        for(int i=1; i<=n1; i++) {
            fact *= i;
        }

        System.out.println("Factorial of " + n1 + " = " + fact);

        // 153 ==> \(1^{3}+5^{3}+3^{3}=1+125+27=153\)

        // 121

        int num = 121, rev = 0, temp = num;

        while (temp > 0) {
            rev = rev * 10 + temp % 10; // 1
            //System.out.println("rev" + rev);
            temp /= 10;
            //System.out.println("temp" + temp);
        }

        if (num == rev)
            System.out.println(num + " is Palindrome");
        else
            System.out.println(num + " is NOT Palindrome");


        int num1 = 1234;
        int rev1 = 0;

        while(num1 > 0) {
            rev1 = rev1 * 10 + num1 %10;
            num1 /=10;
        }

        System.out.println(rev1);

        while (rev1 > 0) {
            switch (rev1 % 10) {
                case 0 -> System.out.print("Zero ");
                case 1 -> System.out.print("One ");
                case 2 -> System.out.print("Two ");
                case 3 -> System.out.print("Three ");
                case 4 -> System.out.print("Four ");
                case 5 -> System.out.print("Five ");
                case 6 -> System.out.print("Six ");
                case 7 -> System.out.print("Seven ");
                case 8 -> System.out.print("Eight ");
                case 9 -> System.out.print("Nine ");
            }
            rev1 /= 10;
        }
    }
}
