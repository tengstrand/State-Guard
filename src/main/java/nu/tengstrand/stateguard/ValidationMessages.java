package nu.tengstrand.stateguard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class ValidationMessages implements Iterable<ValidationMessage> {
    private ValidationMessage currentValidationMessage;
    private final List<ValidationMessage> messages = new ArrayList<ValidationMessage>();

    private ValidationMessages() {
    }

    private ValidationMessages(String message) {
        currentValidationMessage = new ValidationMessage(message);
        messages.add(currentValidationMessage);
    }

    private ValidationMessages(List<ValidationMessage> messages) {
        this.messages.addAll(messages);
    }

    public static ValidationMessages withoutMessage() {
        return new ValidationMessages();
    }

    public static ValidationMessages message(String message) {
        return new ValidationMessages(message);
    }

    public ValidationMessages arguments(Object... arguments) {
        throwExceptionIfCurrentValidationMessageIsNotInitialized();
        currentValidationMessage.arguments(arguments);
        return this;
    }

    public ValidationMessages messageKey(String messageKey) {
        throwExceptionIfCurrentValidationMessageIsNotInitialized();
        currentValidationMessage.messageKey(messageKey);
        return this;
    }

    private void throwExceptionIfCurrentValidationMessageIsNotInitialized() {
        if (currentValidationMessage == null) {
            throw new IllegalStateException("Replace the call to withoutMessage() with addMessage");
        }
    }

    public ValidationMessages addMessage(String message) {
        currentValidationMessage = new ValidationMessage(message);
        messages.add(currentValidationMessage);
        return this;
    }

    public ValidationMessages mergeMessages(ValidationMessages validationMessages) {
        List<ValidationMessage> messages = new ArrayList<ValidationMessage>();
        messages.addAll(validationMessages.messages);
        messages.addAll(this.messages);

        return new ValidationMessages(messages);
    }

    public List<String> formattedMessages() {
        List<String> formattedMessages = new ArrayList<String>();
        for (ValidationMessage message : messages) {
            formattedMessages.add(message.getFormattedMessage());
        }
        return formattedMessages;
    }

    public List<String> formattedMessages(ResourceBundle resourceBundle) {
        List<String> formattedMessages = new ArrayList<String>();
        for (ValidationMessage message : messages) {
            formattedMessages.add(message.getFormattedMessage(resourceBundle));
        }
        return formattedMessages;
    }

    String firstUnformattedMessage() {
        if (messages.size() > 0) {
            return messages.iterator().next().message;
        }
        return "";
    }

    public String firstMessage() {
        if (messages.size() > 0) {
            return messages.iterator().next().getFormattedMessage();
        }
        return "";
    }

    public String firstMessage(ResourceBundle resourceBundle) {
        if (messages.size() > 0) {
            return messages.iterator().next().getFormattedMessage(resourceBundle);
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
