package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.ValidationId;
import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class NonEmptyString implements Validatable {
    private String string;
    private final ValidationId validationId;

    /**
     * Lazy initialization.
     */
    public NonEmptyString(ValidationId validationId) {
        this(null, validationId);
    }

    public NonEmptyString(String string, ValidationId validationId) {
        this.string = string;
        this.validationId = validationId;
    }

    public String value() {
        return string;
    }

    public void setValue(String string) {
        this.string = string;
    }

    public boolean isValid() {
        return string != null && string.length() > 0;
    }

    public ValidationMessages validationMessages() {
        return new ValidationMessages("Attribute '" + validationId + "' can not be empty", validationId);
    }
}
