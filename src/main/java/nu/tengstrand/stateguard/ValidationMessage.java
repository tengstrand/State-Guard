package nu.tengstrand.stateguard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidationMessage {
    public final String message;
    public List<Attribute> attributes = new ArrayList<Attribute>();

    public ValidationMessage(String message, Attribute attribute, Attribute... attributes) {
        this.message = message;
        this.attributes.add(attribute);
        this.attributes.addAll(Arrays.asList(attributes));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationMessage that = (ValidationMessage) o;

        if (attributes != null ? !attributes.equals(that.attributes) : that.attributes != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return message;
    }
}
