package kg.it_academy.sell_soul.exception;

public class ApiFailException extends RuntimeException{
    public ApiFailException(String message) {
        super(message);
    }

    public ApiFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
