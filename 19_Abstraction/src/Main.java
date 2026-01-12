public class Main {
    public static void main(String[] args) {
        DatabaseConnection mySQLConnection = new MySQLConnection("localhost", 1234,
                "root", "password", "master");

        mySQLConnection.connect();
        mySQLConnection.executeQuery("SELECT * FROM users");
        mySQLConnection.disconnect();

        DatabaseConnection db =
                new MongoDBConnection(
                        "localhost",
                        27017,
                        "admin",
                        "password",
                        "users"
                );

        db.connect();
        db.executeQuery("{ find: 'users' }");
        db.disconnect();

        Readable document = new Document("Test");
        document.read();
    }

    // Open/closed Principle

    // Abstraction
    // Implementation
    // Abstract or interface

    // Encapsulation
    // Protect data ==> Private
}


interface Readable {
    void read();
}

interface Writable {
    void write(String content);
}

interface Searchable {
    void search(String keyword);
}

interface Shareable {
    void share(String platform);
}


class Document implements Readable, Writable, Searchable, Shareable {
    private String content;
    private String title;

    public Document(String title) {
        this.title = title;
        this.content = "";
    }

    @Override
    public void read() {
        System.out.println("Reading document: " + title);
        System.out.println("Content: " + content);
    }

    @Override
    public void write(String newContent) {
        this.content += newContent;
        System.out.println("Content written to " + title);
    }

    @Override
    public void search(String keyword) {
        if (content.contains(keyword)) {
            System.out.println("Keyword '" + keyword + "' found in " + title);
        } else {
            System.out.println("Keyword not found");
        }
    }

    @Override
    public void share(String platform) {
        System.out.println("Sharing " + title + " on " + platform);
    }
}

class Video implements Readable, Shareable {
    private String title;
    private int duration;

    public Video(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public void read() {
        System.out.println("Playing video: " + title);
        System.out.println("Duration: " + duration + " seconds");
    }

    @Override
    public void share(String platform) {
        System.out.println("Sharing video " + title + " on " + platform);
    }
}