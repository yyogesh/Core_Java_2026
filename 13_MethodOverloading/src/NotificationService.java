public class NotificationService  {

    /// Email notification function
    public void sendNotification(String email, String message) {
        System.out.println("Email sent to: " + email);
        System.out.println("Message: " + message);
        System.out.println("---");
    }

    /// Phone message notification
    public void sendNotification(long phoneNumber, String message) {
        System.out.println("SMS sent to: " + phoneNumber);
        System.out.println("Message: " + message);
        System.out.println("---");
    }

    public void sendNotification(String email, String message, String priority) {
        System.out.println("Priority: " + priority);
        System.out.println("Email sent to: " + email);
        System.out.println("Message: " + message);
        System.out.println("---");
    }

    public void sendNotification(String[] emails, String message) {
        System.out.println("Bulk email notification:");
        for (String email : emails) {
            System.out.println("Sent to: " + email);
        }
        System.out.println("Message: " + message);
        System.out.println("---");
    }
}
