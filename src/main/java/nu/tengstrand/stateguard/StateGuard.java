package nu.tengstrand.stateguard;

import nu.tengstrand.stateguard.example.book.attributes.BookBinding;

public abstract class StateGuard<T> implements Validatable {
    protected abstract Validatable validatable();
    protected abstract T createValidState();

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
        return createValidState();
    }
}
