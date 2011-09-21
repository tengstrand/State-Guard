package nu.tengstrand.stateguard.validator;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class NotNull<T> implements Validatable {
    private T notNullObject;
    private final Object id;

    /**
     * Lazy initialization.
     */
    public NotNull(Object id) {
        this(null, id);
    }

    public NotNull(T notNullObject, Object id) {
        this.notNullObject = notNullObject;
        this.id = id;
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
        return new ValidationMessages("Attribute '" + id + "' can not be null", id);
    }
}
