package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Attribute;
import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class NotNull<T> implements Validatable {
    private T notNullObject;
    private final Attribute attribute;

    /**
     * Lazy initialization.
     */
    public NotNull(String attributeName) {
        this(null, attributeName);
    }

    public NotNull(T notNullObject, String attributeName) {
        this.notNullObject = notNullObject;
        this.attribute = new Attribute(attributeName);
    }

    public T value() {
        return notNullObject;
    }

    public void setValue(T notNullObject) {
        this.notNullObject = notNullObject;
    }

    public boolean isValid() {
        return notNullObject != null;
    }

    public ValidationMessages validationMessages() {
        return new ValidationMessages("Attribute '" + attribute + "' can not be null", attribute);
    }
}
