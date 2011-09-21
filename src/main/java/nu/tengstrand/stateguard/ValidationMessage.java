package nu.tengstrand.stateguard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationMessage {
    public final String message;
    public final ValidationId validationId;

    public ValidationMessage(String message, ValidationId validationId) {
        this.message = message;
        this.validationId = validationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationMessage that = (ValidationMessage) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (validationId != null ? !validationId.equals(that.validationId) : that.validationId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (validationId != null ? validationId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return message;
    }
}
