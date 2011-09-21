package nu.tengstrand.stateguard;

public abstract class StateGuard<T> implements Validatable {
    protected abstract Validatable validatable();
    protected abstract ValidStateCreator<T> validStateCreator();

    public boolean isValid() {
        return validatable().isValid();
    }

    public ValidationMessages validationMessages() {
        return validatable().validationMessages();
    }

    public void execute(Command command) {
        validationMessages().execute(command);
    }

    public T asValidState() {
        if (!validatable().isValid()) {
            throw new ValidateException(validatable().validationMessages().firstMessage());
        }
        return validStateCreator().createValidState();
    }
}
