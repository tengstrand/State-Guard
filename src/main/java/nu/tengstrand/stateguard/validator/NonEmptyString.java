package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Attribute;
import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class NonEmptyString implements Validatable {
    private String string;
    private final Attribute attribute;

    /**
     * Lazy initialization.
     */
    public NonEmptyString(String attributeName) {
        this(null, attributeName);
    }

    public NonEmptyString(String string, String attributeName) {
        this.string = string;
        this.attribute = new Attribute(attributeName);
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
        return new ValidationMessages("Attribute '" + attribute + "' can not be empty", attribute);
    }
}
