public class Main {
    public static void main(String arg[]){
        // for loop
        // while loop
        // do while loop
        // for each loop

        int i = 1;
        while(i <= 5) {
            System.out.println(i);
            i++;
        }

        int number = 98342; // 98342 % 10 ==> 2, 4, 3, 8, 9
        // 9834 // 98342/10 ==> 9834
        // 9834/10 ==> 983
        // 983/10 ==> 98
        // 98/10 ==> 9
        // 9/10 ==> 0
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            System.out.println("Sum is :: " + sum);
            number /= 10;
            System.out.println("Number is ::" + number);
        }

        System.out.println("Sum of digit is::" + sum);

        // do{ } while()

        GuessingGame.guessTheNumber();
    }
}
