abstract class DatabaseConnection {
    protected String host;
    protected int port;
    protected String username;
    protected String password;
    protected boolean isConnected;

    public DatabaseConnection(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.isConnected = false;
    }

    public abstract void connect();
    public abstract void disconnect();
    public abstract void executeQuery(String query);

    public void logConnection() {
        System.out.println("Connecting to " + host + ":" + port);
    }

    public boolean isConnected() {
        return isConnected;
    }
}
