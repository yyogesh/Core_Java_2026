public class ApiResponse {
    private int statusCode;
    private String message;

    public ApiResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public void sendResponse() {
        if (statusCode == HttpStatus.OK) {
            System.out.println("Success: " + message);
        } else if (statusCode == HttpStatus.NOT_FOUND) {
            System.out.println("Error: Resource not found - " + message);
        } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR) {
            System.out.println("Server Error: " + message);
        }
    }
}
