package nu.tengstrand.stateguard;

import java.text.MessageFormat;
import java.util.Arrays;

public class ValidationMessage {
    public final String message;
    public Object[] arguments;

    private ValidationMessage(String message) {
        this.message = message;
    }

    public static ValidationMessage message(String message) {
        return new ValidationMessage(message);
    }

    public ValidationMessage arguments(Object... arguments) {
        this.arguments = arguments;
        return this;
    }

    public String getMessage() {
        String msg = MessageFormat.format(message, arguments);
        msg = MessageFormat.format("Attribute ''{0}'' can not be null", "kalle");
        return msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationMessage that = (ValidationMessage) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(arguments, that.arguments)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (arguments != null ? Arrays.hashCode(arguments) : 0);
        return result;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
