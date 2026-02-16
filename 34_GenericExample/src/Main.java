import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApiResponse<User> userApiResponse = new ApiResponse<>();
        ApiResponse<Product> userApiResponse = new ApiResponse<>();

        Repository<User, Long> userRepo = new Repository<>();
        Repository<Product, String> productRepo = new Repository<>();
        Repository<Order, UUID> orderRepo = new Repository<>();
    }
}

class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;

    public ApiResponse(int statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }
}


class Repository<T, ID> {
    private Map<ID, T> database = new HashMap<>();

    public void save(T entity, ID id) {
        database.put(id, entity);
    }

    public T findById(ID id) {
        return database.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(database.values());
    }

    public void delete(ID id) {
        database.remove(id);
    }
}


interface CrudService<T, ID> {
    T create(T entity);
    T update(ID id, T entity);
    T getById(ID id);
    List<T> getAll();
    void delete(ID id);
}


public class UserService implements CrudService<User, Long> {
    private Repository<User, Long> repository = new Repository<>();

    @Override
    public User create(User user) {
        // Business logic: validate, hash password, etc.
        Long id = generateId();
        repository.save(user, id);
        return user;
    }

    @Override
    public User getById(Long id) {
        return repository.findById(id);
    }
}

StatisticsCalculator<Integer> intCalc = new StatisticsCalculator<>();
StatisticsCalculator<Double> doubleCalc = new StatisticsCalculator<>();

public class StatisticsCalculator<T extends Number> {

    public double calculateAverage(List<T> numbers) {
        double sum = 0;
        for (T number : numbers) {
            sum += number.doubleValue(); // We know T has doubleValue()
        }
        return sum / numbers.size();
    }
}

public void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

public double sumPrices(List<? extends Product> products) {
    double total = 0;
    for (Product p : products) {
        total += p.getPrice(); // Can read as Product
    }
    return total;
    // Can't add to the list - we don't know exact type
}


public class Cache<K, V> {
    private Map<K, V> cache = new ConcurrentHashMap<>();
    private Map<K, Long> expiryTimes = new ConcurrentHashMap<>();

    public void put(K key, V value, long ttlSeconds) {
        cache.put(key, value);
        expiryTimes.put(key, System.currentTimeMillis() + (ttlSeconds * 1000));
    }

    public V get(K key) {
        Long expiryTime = expiryTimes.get(key);
        if (expiryTime != null && System.currentTimeMillis() > expiryTime) {
            cache.remove(key);
            expiryTimes.remove(key);
            return null;
        }
        return cache.get(key);
    }
}