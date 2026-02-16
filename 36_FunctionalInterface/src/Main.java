import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator() {
            @Override
            public int operate(int a, int b) {
                return a +b;
            }
        };

        System.out.println(calculator.operate(10, 5));

        Calculator add = (a, b) -> a + b;
        Calculator sub = (a, b) -> a - b;
        Calculator mul = (a, b) -> a * b;

        System.out.println(add.operate(10, 5));

        Predicate<Integer> isAdult = a -> a >= 18;

        System.out.println(isAdult.test(20));
    }
}


@FunctionalInterface
interface abc {
    boolean canHave();
    // boolean canHave1();

    // default, static
}

// Lambda expression
// Stream API
@FunctionalInterface
interface GreetingService {
    void greet(String name);
}

class FormalGreeting implements GreetingService {
    @Override
    public void greet(String name) {
        System.out.println("Good Morning, Mr/Ms " + name);
    }
}


@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

