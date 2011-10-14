package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class IntegerValidator implements Validatable {
    private final String attributeName;
    private String value;
    private String messageKey;

    protected IntegerValidator(String attributeName) {
        this.attributeName = attributeName;
    }

    public static IntegerValidator attributeName(String attributeName) {
        return new IntegerValidator(attributeName);
    }

    public IntegerValidator setValue(String value) {
        this.value = value;
        return this;
    }

    public IntegerValidator withMessageKey(String messageKey) {
        this.messageKey = messageKey;
        return this;
    }

    public int value() {
        return java.lang.Integer.valueOf(value);
    }

    public String stringValue() {
        return value;
    }

    public boolean isValid() {
        try {
            java.lang.Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public ValidationMessages validationMessages() {
        if (isValid()) {
            ValidationMessages.withoutMessage();
        }
        return ValidationMessages.message("Attribute ''{0}'' is not a valid integer").arguments(attributeName).messageKey(messageKey);
    }
}
