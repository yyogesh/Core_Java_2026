public class MongoDBConnection extends DatabaseConnection {
    private String collectionName;

    public MongoDBConnection(String host, int port, String username,
                             String password, String collection) {
        super(host, port, username, password);
        this.collectionName = collection;
    }

    @Override
    public void connect() {
        logConnection();
        System.out.println("MongoDB connection established to collection: " + collectionName);
        isConnected = true;
    }

    @Override
    public void disconnect() {
        System.out.println("MongoDB connection closed");
        isConnected = false;
    }

    @Override
    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("Executing MongoDB query: " + query);
        }
    }
}
