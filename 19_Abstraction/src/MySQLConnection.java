public class MySQLConnection extends DatabaseConnection {
    private String databaseName;

    public MySQLConnection(String host, int port, String username,
                           String password, String dbName) {
        super(host, port, username, password);
        this.databaseName = dbName;
    }

    @Override
    public void connect() {
        logConnection();
        System.out.println("MySQL connection established to " + databaseName);
        isConnected = true;
    }

    @Override
    public void disconnect() {
        System.out.println("MySQL connection closed");
        isConnected = false;
    }

    @Override
    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("Executing MySQL query: " + query);
        } else {
            System.out.println("Not connected to database");
        }
    }
}
