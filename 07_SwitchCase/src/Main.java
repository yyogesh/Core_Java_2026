import java.util.Scanner;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class Main {
    public static void main(String arg[]) {
        // if else ==> else if
        // switch case
        // ternary
        // && ||

        Scanner sc = new Scanner(System.in);
        String grade = sc.next().toUpperCase();

        switch (grade) {
            case "A":
                System.out.println("Excellent");
                break;
            case "B":
                System.out.println("Excellent1");
                break;
                //case "C" -> System.out.println("Excellent3");
            default:
                System.out.println("Excellent2");
        }

        switch (grade) {
            case "A" -> System.out.println("Excellent");
            case "B" -> System.out.println("Very Good");
            case "C" -> System.out.println("Good");
            case "D" -> System.out.println("Needs Improvement");
            case "F" -> System.out.println("Fail");
            default -> System.out.println("Invalid Grade");
        }

        // if
        // else if
        // else if
        // else

        Day today = Day.SATURDAY;

        switch (today) {
            case SATURDAY, SUNDAY -> {
                System.out.println("Weekend ");
            }
            case MONDAY -> System.out.println("Start of work");
            default -> System.out.println("Working day");
        }


        // ******************************************
        System.out.print("Enter Department (IT/HR): ");
        String dept = sc.next();

        System.out.print("Enter Level (1/2): ");
        int level = sc.nextInt();

        switch (dept) {
            case "IT":
                switch (level) {
                    case 1 -> System.out.println("Junior IT Staff");
                    case 2 -> System.out.println("Senior IT Staff");
                }
                break;

            case "HR":
                switch (level) {
                    case 1 -> System.out.println("Junior HR Staff");
                    case 2 -> System.out.println("Senior HR Staff");
                }
                break;

            default:
                System.out.println("Invalid Department");
        }

    }
}
