import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello Student");
            }
        };

        Greeting g1 = () -> {
            System.out.println("Hello Student");
        };

        Greeting g2 = () -> System.out.println("Hello Student");

//        List<Employee> employees = List.of(
//                new Employee("John", 50000),
//                new Employee("Alice", 70000),
//                new Employee("Bob", 40000)
//        );

//        employees.stream().filter().forEach()

        List<String> names = Arrays.asList("ABC", "XYZ", "PQR");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(names, (a, b) -> a.compareTo(b));

       // names.sort(String::compareTo);

        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();

        MathOperation add      = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
    }
}

@FunctionalInterface
interface Greeting {
    void sayHello();
    // void sayHello1();
}

//class HelloGreeting implements Greeting {
//    public void sayHello() {
//        System.out.println("Hello Student");
//    }
//}

@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}