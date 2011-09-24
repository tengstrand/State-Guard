package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessage;
import nu.tengstrand.stateguard.ValidationMessages;

public class NotNull<T> implements Validatable {
    private final String attributeName;
    private T notNullObject;
    private String messageKey;

    private NotNull(String attributeName) {
        this.attributeName = attributeName;
    }

    public static NotNull attributeName(String attributeName) {
        return new NotNull(attributeName);
    }

    public void withValue(T notNullObject) {
        this.notNullObject = notNullObject;
    }

    public NotNull withMessageKey(String messageKey) {
        this.messageKey = messageKey;
        return this;
    }

    public T value() {
        return notNullObject;
    }

    public boolean isValid() {
        return notNullObject != null;
    }

    public ValidationMessages validationMessages() {
        return ValidationMessages.add(ValidationMessage.message("Attribute ''{0}'' can not be null").arguments(attributeName).messageKey(messageKey));
    }
}
