package nu.tengstrand.stateguard;

import java.util.*;

public class ValidationMessages implements Iterable<ValidationMessage> {
    private final List<ValidationMessage> messages = new ArrayList<ValidationMessage>();

    private ValidationMessages() {
    }

    private ValidationMessages(List<ValidationMessage> messages) {
        this.messages.addAll(messages);
    }

    private ValidationMessages(ValidationMessage validationMessage) {
        messages.add(validationMessage);
    }

    public static ValidationMessages withoutMessage() {
        return new ValidationMessages();
    }

    public static ValidationMessages add(ValidationMessage validationMessage) {
        return new ValidationMessages(validationMessage);
    }

    public ValidationMessages mergeMessages(ValidationMessages validationMessages) {
        List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
        messages.addAll(validationMessages.messages);
        messages.addAll(this.messages);

        return new ValidationMessages(messages);
    }

    public void printMessages() {
        for (ValidationMessage message : messages) {
            System.out.println(message.getFormattedMessage());
        }
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
