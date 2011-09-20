package nu.tengstrand.stateguard;

public class ValidateException extends IllegalStateException {
    public ValidateException(String message) {
        super(message);
    }
}
