package int222.project.Dora.Exception;

public class LoginException extends RuntimeException{
    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
