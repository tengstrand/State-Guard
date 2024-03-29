package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class NonEmptyString implements Validatable {
    private String string;
    private final String attributeName;
    private String messageKey;

    protected NonEmptyString(String attributeName) {
        this.attributeName = attributeName;
    }

    public static NonEmptyString attributeName(String attributeName) {
        return new NonEmptyString(attributeName);
    }

    public NonEmptyString setValue(String value) {
        this.string = value;
        return this;
    }

    public NonEmptyString messageKey(String messageKey) {
        this.messageKey = messageKey;
        return this;
    }

    public String value() {
        return string;
    }

    public boolean isValid() {
        return string != null && string.length() > 0;
    }

    public ValidationMessages validationMessages() {
        if (isValid()) {
            return ValidationMessages.withoutMessage();
        }
        return ValidationMessages.message("Attribute ''{0}'' can not be empty").arguments(attributeName).messageKey(messageKey);
    }
}
