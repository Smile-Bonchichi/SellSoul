package kg.it_academy.sell_soul.exception;

public class ApiErrorException extends RuntimeException {
    public ApiErrorException(String message) {
        super(message);
    }

    public ApiErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
