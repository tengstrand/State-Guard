package nu.tengstrand.stateguard;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ValidationMessage {
    final String message;
    Object[] arguments;
    String messageKey;

    public ValidationMessage(String message) {
        this.message = message;
    }

    public ValidationMessage arguments(Object... arguments) {
        this.arguments = arguments;
        return this;
    }

    public ValidationMessage messageKey(String messageKey) {
        this.messageKey = messageKey;
        return this;
    }

    public String getFormattedMessage() {
        String msg = MessageFormat.format(message, arguments);
        return msg;
    }

    public String getFormattedMessage(ResourceBundle resourceBundle) {
        if (messageKey != null) {
            String message = resourceBundle.getString(messageKey);
            if (message != null) {
                return MessageFormat.format(message, arguments);
            }
        }
        return MessageFormat.format(message, arguments);
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
        return "ValidationMessage{message=" + message + ", arguments=" + Arrays.asList(arguments) + "}";
    }
}
