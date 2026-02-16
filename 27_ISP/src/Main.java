public class Main {
    public static void main(String[] args) {

    }
}

interface MultiFunctionDeviceBad {
    void print(String document);
    void scan(String document);
    void fax(String document);
    void photocopy(String document);
    void staple(String document);
    void emailDocument(String document, String email);
}

interface Printable {
    void print(String document);
}

interface Scannable {
    void scan(String document);
}

interface Faxable {
    void fax(String document);
}

interface Photocopiable {
    void photocopy(String document);
}

interface EmailCapable {
    void emailDocument(String document, String email);
}

interface Stapleable {
    void staple(String document);
}

class BasicPrinter implements Printable {
    private String model;

    public BasicPrinter(String model) {
        this.model = model;
    }

    @Override
    public void print(String document) {
        System.out.println("\n[" + model + " - BASIC PRINTER]");
        System.out.println("🖨️  Printing: " + document);
        System.out.println("   Status: Print job completed");
    }
}

class Scanner implements Scannable {
    private String model;

    public Scanner(String model) {
        this.model = model;
    }

    @Override
    public void scan(String document) {
        System.out.println("\n[" + model + " - SCANNER]");
        System.out.println("📄 Scanning: " + document);
        System.out.println("   Resolution: 600 DPI");
        System.out.println("   Status: Scan completed");
    }
}
