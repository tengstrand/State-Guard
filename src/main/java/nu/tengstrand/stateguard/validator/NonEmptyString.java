package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class NonEmptyString implements Validatable {
    private String string;
    private final Object id;

    /**
     * Lazy initialization.
     */
    public NonEmptyString(Object id) {
        this(null, id);
    }

    public NonEmptyString(String string, Object id) {
        this.string = string;
        this.id = id;
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
        return new ValidationMessages("Attribute '" + id + "' can not be empty", id);
    }
}
