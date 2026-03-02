import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // x ===> y
        // filter, map, sorted, distinct, limit
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);

        List<Integer> evens = numbers.stream().filter(n -> n % 2 ==0)
                .toList();

        System.out.println("Even numbers: " + evens);

        numbers.stream().sorted(Comparator.reverseOrder()).limit(3);

//        x -> System.out.println(x);
//
//        System.out::println;
//        (x, y) -> Math.max(x, y);
//
//        Math.max

        List<String> names = List.of("A", "B", "C");

        names.forEach(System.out::println);

        List<String> names1 = List.of("john", "jane", "doe");

        names1.stream().map(String::toUpperCase).forEach(System.out::println);

        numbers.stream().map(n -> n * n).toList();

        List<Employee> employees = Arrays.asList(
                new Employee("Alice",   "IT",      85000, 30),
                new Employee("Bob",     "HR",      55000, 45),
                new Employee("Charlie", "IT",      95000, 35),
                new Employee("Diana",   "Finance", 75000, 28),
                new Employee("Eve",     "HR",      60000, 32),
                new Employee("Frank",   "IT",      70000, 40),
                new Employee("Grace",   "Finance", 80000, 29)
        );

        employees.stream().filter(e -> e.getDepartment().equals("IT"));

        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        List<String> sentences = Arrays.asList(
                "Java is great",
                "Java streams are powerful",
                "Streams make Java elegant"
        );

        Map<String, Long> wordFrequency = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

    }
}

class Employee {
    String name;
    String department;
    double salary;
    int age;

    Employee(String name, String department, double salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return name + " [" + department + ", $" + salary + "]";
    }
}
