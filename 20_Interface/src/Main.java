public class Main {
    public static void main(String[] args) {
        DatabaseConnection mysql = new MySQLConnection();
        DatabaseManager databaseManager = new DatabaseManager(mysql);
        databaseManager.performOperation();

        DatabaseManager databaseManager1 = new DatabaseManager(new PostgreSQLConnection());
        databaseManager1.performOperation();

        PaymentGateway paymentGateway = new StripePayment();

        paymentGateway.refundPayment(100);

        String text = "  hello world  ";
        System.out.println(StringUtils.isEmpty(text));
        System.out.println(StringUtils.capitalize(text));
        System.out.println(StringUtils.reverse(text));

        Vehicle car = VehicleFactory.createCar("Tesla Model 3");
        Vehicle truck = VehicleFactory.createTruck("Ford F-150");
        Vehicle bike = VehicleFactory.createMotorcycle("Yamaha R1");

        car.display();
        truck.display();
        bike.display();

    }
}


interface DatabaseConnection {
    void connect(String url);
    void disconnect();
    void executeQuery(String query);
    boolean isConnected();
}


class MySQLConnection implements DatabaseConnection {
    private boolean connected = false;

    @Override
    public void connect(String url) {
        System.out.println("Connecting to MySQL at: " + url);
        connected = true;
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL");
        connected = false;
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing MySQL query: " + query);
    }

    @Override
    public boolean isConnected() {
        return connected;
    }
}

class PostgreSQLConnection implements DatabaseConnection {
    private boolean connected = false;

    @Override
    public void connect(String url) {
        System.out.println("Connecting to PostgreSQL at: " + url);
        connected = true;
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from PostgreSQL");
        connected = false;
    }

    @Override
    public void executeQuery(String query) {
        System.out.println("Executing PostgreSQL query: " + query);
    }

    @Override
    public boolean isConnected() {
        return connected;
    }
}

class DatabaseManager {
    private DatabaseConnection connection;

    public DatabaseManager(DatabaseConnection connection) {
        this.connection = connection;
    }

    public void performOperation() {
        connection.connect("localhost:3306");
        connection.executeQuery("SELECT * FROM users");
        connection.disconnect();
    }
}

