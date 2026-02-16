public class Main {
    public static void main(String[] args) {
        // Creational Patterns
        // Structural Patterns
        // Behavioral Patterns

        // Database connection, logger, configuration manager, cache management

        // DatabaseConnection databaseConnection = new DatabaseConnection();
        DatabaseConnection db1= DatabaseConnection.getInstance();
        DatabaseConnection db2= DatabaseConnection.getInstance();
        db1.executeQuery("Select * from users");
        System.out.println(db1 == db2);
    }
}

class DatabaseConnection {
    private static final DatabaseConnection instance = new DatabaseConnection();
    private DatabaseConnection() {
        System.out.println("Database connection established!");
    }

    public static DatabaseConnection getInstance() {
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }
}
