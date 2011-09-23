package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessage;
import nu.tengstrand.stateguard.ValidationMessages;

public class NonEmptyString implements Validatable {
    private String string;
    private final String attributeName;

    private NonEmptyString(String attributeName) {
        this.attributeName = attributeName;
    }

    public static NonEmptyString attributeName(String attributeName) {
        return new NonEmptyString(attributeName);
    }

    public NonEmptyString withValue(String value) {
        this.string = value;
        return this;
    }

    public String value() {
        return string;
    }

    public boolean isValid() {
        return string != null && string.length() > 0;
    }

    public ValidationMessages validationMessages() {
        return ValidationMessages.add(ValidationMessage.message("Attribute ''{0}'' can not be empty").arguments(attributeName));
    }
}
