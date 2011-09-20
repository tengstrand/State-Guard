package nu.tengstrand.stateguard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidationMessages implements Iterable<ValidationMessage> {
    private final List<ValidationMessage> messages = new ArrayList<ValidationMessage>();

    public ValidationMessages() {
    }

    public ValidationMessages(String message, Attribute attribute, Attribute... attributes) {
        messages.add(new ValidationMessage(message, attribute, attributes));
    }

    private ValidationMessages(ValidationMessages validationMessages1, ValidationMessages validationMessages2) {
        messages.addAll(validationMessages1.messages);
        messages.addAll(validationMessages2.messages);
    }

    public ValidationMessages createMessages(ValidationMessages validationMessages) {
        return new ValidationMessages(this, validationMessages);
    }

    public String firstMessage() {
        if (messages.size() > 0) {
            return messages.get(0).message;
        }
        return "";
    }

    public Iterator<ValidationMessage> iterator() {
        return messages.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationMessages that = (ValidationMessages) o;

        if (messages != null ? !messages.equals(that.messages) : that.messages != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return messages != null ? messages.hashCode() : 0;
    }

    @Override
    public String toString() {
        return messages.toString();
    }
}
