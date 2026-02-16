import java.util.*;

// import java.util.Observable;

public class Main {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL");
        appleStock.attach(new MobileApp());
        appleStock.attach(new EmailAlert());
    }
}

class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App: " + stockName + " is now $" + price);
    }
}


class EmailAlert implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Email Alert: Stock " + stockName + " changed to $" + price);
    }
}

interface Observer {
    void update(String stockName, double price);
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

class Stock implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public Stock(String stockName) {
        this.stockName = stockName;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}