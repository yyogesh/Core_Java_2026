public class Main {
    public static void main(String[] args) {

    }
}

//class OrderStatus {
//    public static final int PENDING = 0;
//    public static final int PROCESSING = 1;
//    public static final int SHIPPED = 2;
//}

enum OrderStatus {
    PENDING("Order Placed", "Your order has been received"),
    PAYMENT_CONFIRMED("Payment Confirmed", "Payment processed successfully"),
    PROCESSING("Processing", "We're preparing your order"),
    SHIPPED("Shipped", "Your order is on the way"),
    DELIVERED("Delivered", "Order delivered successfully"),
    CANCELLED("Cancelled", "Order has been cancelled"),
    REFUNDED("Refunded", "Payment has been refunded");

    private final String displayName;
    private final String customerMessage;

    OrderStatus(String displayName, String customerMessage) {
        this.displayName = displayName;
        this.customerMessage = customerMessage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public boolean canTransitionTo(OrderStatus newStatus) {
        return switch (this) {
            case PENDING -> newStatus == PAYMENT_CONFIRMED || newStatus == CANCELLED;
            case PAYMENT_CONFIRMED -> newStatus == PROCESSING || newStatus == CANCELLED;
            case PROCESSING -> newStatus == SHIPPED || newStatus == CANCELLED;
            case SHIPPED -> newStatus == DELIVERED;
            case DELIVERED -> newStatus == REFUNDED;
            case CANCELLED, REFUNDED -> false; // Terminal states
        };
    }

    public boolean isTerminal() {
        return this == DELIVERED || this == CANCELLED || this == REFUNDED;
    }
}

class OrderService {
    public void updateOrderStatus(Order order, OrderStatus newStatus) {
        if(order.getStatus().canTransitionTo(newStatus)) {

        }

        // newStatus.isTerminal();
    }
}

class Order {

    private Long id;
    private OrderStatus status;
    private String customerEmail;

    public Order(Long id, String customerEmail) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.status = OrderStatus.PENDING; // default state
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}