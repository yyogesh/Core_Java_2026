import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database mysqlDB = new MySQLDatabase("localhost", 3306);
        EmployeeService devService = new EmployeeService(mysqlDB);
        devService.addEmployee("Alice Johnson", 85000);
        devService.getEmployee(1);

        Database postgresDB = new PostgreSQLDatabase("prod-server.com", 5432);
        EmployeeService prodService = new EmployeeService(postgresDB);
        prodService.addEmployee("Bob Williams", 95000);
        prodService.getAllEmployees();

        Database postgresDB1 = new PostgreSQLDatabase("prod-server.com", 5432) {
            @Override
            public void connect() {

            }
        };

        postgresDB1.connect();
    }
}

class MySQLDatabaseBad {
    public void connectMySQL() {
        System.out.println("🔌 Connecting to MySQL Database...");
        System.out.println("   Host: localhost:3306");
        System.out.println("   Driver: com.mysql.jdbc.Driver");
    }

    public void executeQueryMySQL(String query) {
        System.out.println("📊 Executing MySQL Query: " + query);
        System.out.println("   Engine: InnoDB");
    }

    public void closeMySQL() {
        System.out.println("🔒 Closing MySQL connection");
    }
}


class EmployeeServiceBad {
    private MySQLDatabaseBad database; // Tight coupling to MySQL!

    public EmployeeServiceBad() {
        this.database = new MySQLDatabaseBad(); // Creating concrete instance
    }

    public void addEmployee(String name, double salary) {
        database.connectMySQL();
        database.executeQueryMySQL(
                "INSERT INTO employees VALUES ('" + name + "', " + salary + ")"
        );
        database.closeMySQL();
        System.out.println("✓ Employee added successfully\n");
    }

    public void getEmployee(int id) {
        database.connectMySQL();
        database.executeQueryMySQL("SELECT * FROM employees WHERE id = " + id);
        database.closeMySQL();
    }
}


interface Database {
    void connect();
    void executeQuery(String query);
    List<String> fetchResults(String query);
    void disconnect();
    String getDatabaseType();
}


class MySQLDatabase implements Database {
    private String host;
    private int port;
    private boolean connected = false;

    public MySQLDatabase(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println("\n[MySQL Database]");
        System.out.println("🔌 Connecting to MySQL...");
        System.out.println("   Host: " + host + ":" + port);
        System.out.println("   Driver: com.mysql.cj.jdbc.Driver");
        System.out.println("   Character Set: UTF-8");
        connected = true;
        System.out.println("   ✓ Connected successfully!");
    }

    @Override
    public void executeQuery(String query) {
        if (!connected) {
            System.out.println("❌ Not connected to database!");
            return;
        }
        System.out.println("📊 Executing: " + query);
        System.out.println("   Storage Engine: InnoDB");
        System.out.println("   Transaction: Auto-commit");
        System.out.println("   ✓ Query executed successfully!");
    }

    @Override
    public List<String> fetchResults(String query) {
        executeQuery(query);
        // Simulating results
        return Arrays.asList("Result1", "Result2", "Result3");
    }

    @Override
    public void disconnect() {
        System.out.println("🔒 Closing MySQL connection");
        connected = false;
        System.out.println("   ✓ Disconnected successfully!");
    }

    @Override
    public String getDatabaseType() {
        return "MySQL";
    }
}

class PostgreSQLDatabase implements Database {
    private String host;
    private int port;
    private boolean connected = false;

    public PostgreSQLDatabase(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println("\n[PostgreSQL Database]");
        System.out.println("🔌 Connecting to PostgreSQL...");
        System.out.println("   Host: " + host + ":" + port);
        System.out.println("   Driver: org.postgresql.Driver");
        System.out.println("   SSL Mode: Prefer");
        connected = true;
        System.out.println("   ✓ Connected successfully!");
    }

    @Override
    public void executeQuery(String query) {
        if (!connected) {
            System.out.println("❌ Not connected to database!");
            return;
        }
        System.out.println("📊 Executing: " + query);
        System.out.println("   MVCC: Enabled");
        System.out.println("   Isolation Level: Read Committed");
        System.out.println("   ✓ Query executed successfully!");
    }

    @Override
    public List<String> fetchResults(String query) {
        executeQuery(query);
        return Arrays.asList("PostgreResult1", "PostgreResult2");
    }

    @Override
    public void disconnect() {
        System.out.println("🔒 Closing PostgreSQL connection");
        connected = false;
        System.out.println("   ✓ Disconnected successfully!");
    }

    @Override
    public String getDatabaseType() {
        return "PostgreSQL";
    }
}

class MongoDBDatabase implements Database {
    private String host;
    private int port;
    private boolean connected = false;

    public MongoDBDatabase(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println("\n[MongoDB Database]");
        System.out.println("🔌 Connecting to MongoDB...");
        System.out.println("   Host: " + host + ":" + port);
        System.out.println("   Driver: mongo-java-driver");
        System.out.println("   Mode: Standalone");
        connected = true;
        System.out.println("   ✓ Connected successfully!");
    }

    @Override
    public void executeQuery(String query) {
        if (!connected) {
            System.out.println("❌ Not connected to database!");
            return;
        }
        // MongoDB uses different syntax
        System.out.println("📊 Executing MongoDB Command: " + query);
        System.out.println("   Collection: Employees");
        System.out.println("   Write Concern: Acknowledged");
        System.out.println("   ✓ Command executed successfully!");
    }

    @Override
    public List<String> fetchResults(String query) {
        executeQuery(query);
        return Arrays.asList("{name: 'John'}", "{name: 'Alice'}");
    }

    @Override
    public void disconnect() {
        System.out.println("🔒 Closing MongoDB connection");
        connected = false;
        System.out.println("   ✓ Disconnected successfully!");
    }

    @Override
    public String getDatabaseType() {
        return "MongoDB";
    }
}

class OracleDatabase implements Database {
    private String host;
    private int port;
    private boolean connected = false;

    public OracleDatabase(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println("\n[Oracle Database]");
        System.out.println("🔌 Connecting to Oracle DB...");
        System.out.println("   Host: " + host + ":" + port);
        System.out.println("   Driver: oracle.jdbc.OracleDriver");
        System.out.println("   Service Name: ORCL");
        connected = true;
        System.out.println("   ✓ Connected successfully!");
    }

    @Override
    public void executeQuery(String query) {
        if (!connected) {
            System.out.println("❌ Not connected to database!");
            return;
        }
        System.out.println("📊 Executing: " + query);
        System.out.println("   PL/SQL Engine: Active");
        System.out.println("   Optimizer: Cost-based");
        System.out.println("   ✓ Query executed successfully!");
    }

    @Override
    public List<String> fetchResults(String query) {
        executeQuery(query);
        return Arrays.asList("OracleResult1", "OracleResult2");
    }

    @Override
    public void disconnect() {
        System.out.println("🔒 Closing Oracle connection");
        connected = false;
        System.out.println("   ✓ Disconnected successfully!");
    }

    @Override
    public String getDatabaseType() {
        return "Oracle";
    }
}

class EmployeeService {
    private Database database; // Depends on abstraction!

    // Dependency Injection through constructor
    public EmployeeService(Database database) {
        this.database = database;
    }

    public void addEmployee(String name, double salary) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("➕ ADDING NEW EMPLOYEE");
        System.out.println("═".repeat(60));
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Database: " + database.getDatabaseType());

        database.connect();
        database.executeQuery(
                "INSERT INTO employees (name, salary) VALUES ('" + name + "', " + salary + ")"
        );
        database.disconnect();

        System.out.println("\n✓ Employee added successfully!");
        System.out.println("═".repeat(60));
    }

    public void getEmployee(int id) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("🔍 FETCHING EMPLOYEE");
        System.out.println("═".repeat(60));
        System.out.println("Employee ID: " + id);
        System.out.println("Database: " + database.getDatabaseType());

        database.connect();
        List<String> results = database.fetchResults(
                "SELECT * FROM employees WHERE id = " + id
        );

        System.out.println("\n📋 Results:");
        for (String result : results) {
            System.out.println("   • " + result);
        }

        database.disconnect();
        System.out.println("═".repeat(60));
    }

    public void getAllEmployees() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("📊 FETCHING ALL EMPLOYEES");
        System.out.println("═".repeat(60));

        database.connect();
        List<String> results = database.fetchResults("SELECT * FROM employees");

        System.out.println("\n📋 Total Records: " + results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println("   " + (i + 1) + ". " + results.get(i));
        }

        database.disconnect();
        System.out.println("═".repeat(60));
    }

    // Can switch database at runtime!
    public void switchDatabase(Database newDatabase) {
        System.out.println("\n🔄 SWITCHING DATABASE");
        System.out.println("   From: " + this.database.getDatabaseType());
        System.out.println("   To: " + newDatabase.getDatabaseType());
        this.database = newDatabase;
        System.out.println("   ✓ Database switched successfully!");
    }
}

