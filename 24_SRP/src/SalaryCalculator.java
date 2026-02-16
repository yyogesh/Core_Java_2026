public class SalaryCalculator {
    public double calculateTax(Employee employee) {
        return employee.getSalary() * 0.20; // 20% tax
    }

    public double calculateBonus(Employee employee) {
        return employee.getSalary() * 0.10; // 10% bonus
    }

    public double calculateNetSalary(Employee employee) {
        double gross = employee.getSalary();
        double bonus = calculateBonus(employee);
        double tax = calculateTax(employee);
        return gross + bonus - tax;
    }
}
