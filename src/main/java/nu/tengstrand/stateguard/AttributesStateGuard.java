package nu.tengstrand.stateguard;

public abstract class AttributesStateGuard<T> implements Validatable {
    protected abstract Attributes attributes();
    protected abstract ValidStateCreator<T> validStateCreator();

    public boolean isValid() {
        return attributes().isValid();
    }

    public ValidationMessages validationMessages() {
        return attributes().validationMessages();
    }

    public T asValidState() {
        if (!attributes().isValid()) {
            throw new ValidateException(attributes().validationMessages().firstMessage());
        }
        return validStateCreator().createValidState();
    }
}
