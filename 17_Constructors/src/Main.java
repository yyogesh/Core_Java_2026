public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        Employee emp2 = new Employee("Alice Smith", "IT", 60000);
        Employee emp3 = new Employee("Bob Johnson", "HR");
//        Employee emp4 = new Employee()
        Employee emp4 = new Employee(emp2);

        emp2.displayInfo();
    }
}

class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double salary;
    private String email;

    public Employee() {
        this.employeeId = this.generateEmployeeId();
        this.department = "General";
        this.salary = 30000.0;
    }

    public Employee(String name, String department, double salary) {
        this.employeeId = generateEmployeeId();
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = generateEmail(name);
    }

    public Employee(String name, String department){
        this(name, department, 35000.0);
    }

    public Employee(Employee other) {
        this.employeeId = generateEmployeeId();
        this.name = other.name;
        this.department = other.department;
        this.salary = other.salary;
        this.email = generateEmail(this.name);
    }

    public void displayInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
        System.out.println("Email: " + email);
    }

    private String generateEmployeeId() {
        return "EMP" + System.currentTimeMillis();
    }

    private String generateEmail(String name) {
        return name.toLowerCase().replace(" ", ".") + "@company.com";
    }
}
