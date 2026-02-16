public class Main {
    public static void main(String[] args) {
        EmployeeBad employeeBad = new EmployeeBad("Alice Johnson", "alice@company.com", 50000);
        employeeBad.generateReport();
        employeeBad.saveToDatabase();
        employeeBad.sendPayslipEmail();

        Employee goodEmployee = new Employee("E001", "Bob Smith", "bob@company.com", 50000);

        SalaryCalculator salaryCalculator = new SalaryCalculator();
        EmployeeRepository repository = new EmployeeRepository();
        EmailService emailService = new EmailService();
        ReportGenerator reportGenerator = new ReportGenerator(salaryCalculator);

        System.out.println("\nStep 1: Calculate Salary");
        double netSalary = salaryCalculator.calculateNetSalary(goodEmployee);
        System.out.println("Net Salary calculated: $" + netSalary);

        System.out.println("\nStep 2: Save to Database");
        repository.save(goodEmployee);

        System.out.println("\nStep 3: Generate Report");
        reportGenerator.generatePayslipReport(goodEmployee);

        System.out.println("\nStep 4: Send Email Notification");
        emailService.sendPayslip(goodEmployee, netSalary);
    }
}

class EmployeeBad {
    private String name;
    private String email;
    private double salary;

    public EmployeeBad(String name, String email, double salary) {
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getEmail() { return email; }

    public double calculateTax() {
        return salary * 0.20; // 20% tax
    }

    public double calculateBonus() {
        return salary * 0.10; // 10% bonus
    }

    public void saveToDatabase() {
        System.out.println("Connecting to database...");
        System.out.println("INSERT INTO employees VALUES ('" + name + "', " + salary + ")");
        System.out.println("Employee saved to database!");
    }

    public void sendPayslipEmail() {
        System.out.println("Connecting to email server...");
        System.out.println("Sending payslip to: " + email);
        System.out.println("Subject: Your Monthly Payslip");
        System.out.println("Salary: $" + salary);
        System.out.println("Email sent successfully!");
    }

    public void generateReport() {
        System.out.println("========== EMPLOYEE REPORT ==========");
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Bonus: $" + calculateBonus());
        System.out.println("====================================");
    }

    // email
    // database
    // tax
}


