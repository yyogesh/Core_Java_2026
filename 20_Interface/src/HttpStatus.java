public interface HttpStatus {
    // HTTP Success codes
    int OK = 200;
    int CREATED = 201;
    int ACCEPTED = 202;

    // HTTP Client Error codes
    int BAD_REQUEST = 400;
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;
    int NOT_FOUND = 404;

    // HTTP Server Error codes
    int INTERNAL_SERVER_ERROR = 500;
    int SERVICE_UNAVAILABLE = 503;
}


interface ApplicationConfig {
    String APP_NAME = "MyApp";
    String VERSION = "1.0.0";
    int MAX_CONNECTIONS = 100;
    int TIMEOUT_SECONDS = 30;
    String DEFAULT_LANGUAGE = "en";
}