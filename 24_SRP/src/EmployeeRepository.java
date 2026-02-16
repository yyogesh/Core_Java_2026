public class EmployeeRepository {
    public void save(Employee employee) {
        System.out.println("\n[DATABASE] Connecting to database...");
        System.out.println("[DATABASE] Executing: INSERT INTO employees VALUES (");
        System.out.println("           id='" + employee.getId() + "',");
        System.out.println("           name='" + employee.getName() + "',");
        System.out.println("           email='" + employee.getEmail() + "',");
        System.out.println("           salary=" + employee.getSalary() + ")");
        System.out.println("[DATABASE] ✓ Employee saved successfully!");
    }

    public Employee findById(String id) {
        System.out.println("\n[DATABASE] Searching for employee with ID: " + id);
        // Simulating database fetch
        return new Employee(id, "John Doe", "john@company.com", 50000);
    }
}
