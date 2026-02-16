public class ReportGenerator {
    private SalaryCalculator calculator;

    public ReportGenerator(SalaryCalculator calculator) {
        this.calculator = calculator;
    }

    public void generatePayslipReport(Employee employee) {
        double tax = calculator.calculateTax(employee);
        double bonus = calculator.calculateBonus(employee);
        double netSalary = calculator.calculateNetSalary(employee);

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        EMPLOYEE PAYSLIP REPORT         ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ Employee ID   : " + employee.getId());
        System.out.println("║ Name          : " + employee.getName());
        System.out.println("║ Email         : " + employee.getEmail());
        System.out.println("║────────────────────────────────────────║");
        System.out.println("║ Gross Salary  : $" + String.format("%.2f", employee.getSalary()));
        System.out.println("║ Bonus (+)     : $" + String.format("%.2f", bonus));
        System.out.println("║ Tax (-)       : $" + String.format("%.2f", tax));
        System.out.println("║────────────────────────────────────────║");
        System.out.println("║ NET SALARY    : $" + String.format("%.2f", netSalary));
        System.out.println("╚════════════════════════════════════════╝");
    }
}
