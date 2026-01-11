import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void guessTheNumber() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int choice;

        System.out.println("🎮 Welcome to Number Guessing Game!");

        do {
            System.out.println("\n1. Play Game");
            System.out.println("2. Check Score");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    int computer = random.nextInt(5) + 1;
                    System.out.print("Guess a number (1-5): ");
                    int user = sc.nextInt();

                    if (user == computer) {
                        System.out.println("🎉 Correct! You win.");
                        score += 10;
                    } else {
                        System.out.println("❌ Wrong! Computer chose: " + computer);
                        score -= 5;
                    }
                }

                case 2 -> System.out.println("⭐ Current Score: " + score);

                case 3 -> System.out.println("👋 Thanks for playing!");

                default -> System.out.println("⚠ Invalid choice!");
            }

        } while (choice != 3);
    }
}
