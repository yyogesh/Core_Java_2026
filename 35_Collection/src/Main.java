import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // List interface , ArrayList, LinkedList, Vector
       // Set interface, HashSet
       // Queue interface

        ArrayList<String> list = new ArrayList<>();// 10 capacity

        ArrayList<String> list1 = new ArrayList<>(100);

        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("A", "B"));

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addProduct(new Product("Laptop", 999.88));

        List<Product> products = Arrays.asList(
                new Product("ABC", 123),
                new Product("xyz", 123)
        );
    }
}

class ShoppingCart {
    private ArrayList<Product> cart = new ArrayList<>();

    public void addProduct(Product product) {
        cart.add(product);
    }

    public void addTopProduct(Product product) {
        cart.add(0, product);
    }

    public void addMultipleProducts(List<Product> products) {
        cart.addAll(products);
    }

}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class Video {
    private String title;
    private int duration; // seconds

    public Video(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() { return title; }
    public int getDuration() { return duration; }
}


class VideoPlaylist {
    private ArrayList<Video> playlist = new ArrayList<>();
    private int currentIndex = 0;

    public Video playVideoAt(int position) {
        if(position >= 0 && position< playlist.size()) {
            Video video = playlist.get(position);
            return video;
        }
        throw new IndexOutOfBoundsException("Invalid position " + position);
    }

    public Video getLastVideo() {
        if(!playlist.isEmpty()) {
            return playlist.get(playlist.size() - 1);
        }
        return null;
    }

    public List<Video> getRecentVideos() {
        List<Video> recent = new ArrayList<>();

        int start = Math.max(0, playlist.size() - 5); // 1, 2, 3, 4, 5, 6, 7
        for(int i = start; i < playlist.size(); i++) {
            recent.add(playlist.get(i));
        }

        return recent;
    }

    public Video playPrevious() {
        if(currentIndex > 0) {
            currentIndex--;
            return playlist.get(currentIndex);
        }
        return null;
    }

    public Video playNext() {
        if(currentIndex< playlist.size()) {
            return playlist.get(currentIndex++);
        }

        return null;
    }
}