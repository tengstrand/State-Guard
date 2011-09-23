package nu.tengstrand.stateguard;

import sun.misc.resources.Messages;

import java.util.*;

public class ValidationMessages implements Iterable<ValidationMessage> {
    private final List<ValidationMessage> messages = new ArrayList<ValidationMessage>();

    private ValidationMessages() {
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
/*
    public ValidationMessage withMessage(ValidationMessage validationMessage) {
        messages.add(validationMessage);
        return this;
    }
  */
    private ValidationMessages(ValidationMessages validationMessages1, ValidationMessages validationMessages2) {
        messages.addAll(validationMessages1.messages);
        messages.addAll(validationMessages2.messages);
    }

    public ValidationMessages createMessages(ValidationMessages validationMessages) {
        return new ValidationMessages(this, validationMessages);
    }

    public void printMessages() {
        for (ValidationMessage message : messages) {
            System.out.println(message.getMessage());
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
