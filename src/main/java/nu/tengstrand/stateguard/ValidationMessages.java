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

    public void executeFormattedMessages(MessageCommand messageCommand) {
        for (ValidationMessage message : messages) {
            messageCommand.execute(message.getFormattedMessage());
        }
    }

    public void executeFormattedMessages(MessageCommand messageCommand, ResourceBundle resourceBundle) {
        for (ValidationMessage validationMessage : messages) {
            messageCommand.execute(validationMessage.getFormattedMessage(resourceBundle));
        }
    }

    public String firstMessage() {
        if (messages.size() > 0) {
            return messages.iterator().next().message;
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
