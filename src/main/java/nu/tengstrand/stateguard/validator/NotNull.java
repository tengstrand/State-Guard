package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class NotNull<T> implements Validatable {
    private final String attributeName;
    private T value;
    private String messageKey;

    private NotNull(String attributeName) {
        this.attributeName = attributeName;
    }

    public static NotNull attributeName(String attributeName) {
        return new NotNull(attributeName);
    }

    public NotNull withValue(T value) {
        this.value = value;
        return this;
    }

    public NotNull withMessageKey(String messageKey) {
        this.messageKey = messageKey;
        return this;
    }

    public T value() {
        return value;
    }

    public boolean isValid() {
        return value != null;
    }

    public ValidationMessages validationMessages() {
        if (isValid()) {
            return ValidationMessages.withoutMessage();
        }
        return ValidationMessages.message("Attribute ''{0}'' can not be null").arguments(attributeName).messageKey(messageKey);
    }
}
