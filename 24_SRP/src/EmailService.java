public class EmailService {
    public void sendPayslip(Employee employee, double netSalary) {
        System.out.println("\n[EMAIL] Connecting to SMTP server...");
        System.out.println("[EMAIL] To: " + employee.getEmail());
        System.out.println("[EMAIL] Subject: Monthly Payslip - " + employee.getName());
        System.out.println("[EMAIL] Body:");
        System.out.println("        Dear " + employee.getName() + ",");
        System.out.println("        Your salary has been processed.");
        System.out.println("        Net Salary: $" + netSalary);
        System.out.println("[EMAIL] ✓ Email sent successfully!");
    }

    public void sendWelcomeEmail(Employee employee) {
        System.out.println("\n[EMAIL] Sending welcome email to: " + employee.getEmail());
        System.out.println("[EMAIL] Welcome to the company, " + employee.getName() + "!");
    }
}
