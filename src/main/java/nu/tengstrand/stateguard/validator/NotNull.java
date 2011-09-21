package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.ValidationId;
import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class NotNull<T> implements Validatable {
    private T notNullObject;
    private final ValidationId validationId;

    /**
     * Lazy initialization.
     */
    public NotNull(ValidationId validationId) {
        this(null, validationId);
    }

    public NotNull(T notNullObject, ValidationId validationId) {
        this.notNullObject = notNullObject;
        this.validationId = validationId;
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
        return new ValidationMessages("Attribute '" + validationId + "' can not be null", validationId);
    }
}
