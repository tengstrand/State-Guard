package nu.tengstrand.stateguard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public abstract class StateGuard<T> implements Validatable {
    private List<Validatable> validators = new ArrayList<Validatable>();

    protected abstract T createValidState();

    protected void addValidator(Validatable validatable) {
        validators.add(validatable);
    }

    protected void addValidators(Validatable validatable, Validatable... validatables) {
        validators.add(validatable);
        validators.addAll(Arrays.asList(validatables));
    }

    public boolean isValid() {
        for (Validatable validator : validators) {
            if (!validator.isValid()) {
                return false;
            }
        }
        return true;
    }

    public ValidationMessages validationMessages() {
        ValidationMessages validationMessages = ValidationMessages.withoutMessage();
        for (Validatable validator : validators) {
            if (!validator.isValid()) {
                validationMessages = validationMessages.mergeMessages(validator.validationMessages());
            }
        }
        return validationMessages;
    }

    public T asValidState() {
        if (!isValid()) {
            throw new ValidateException(firstValidationMessage());
        }
        return createValidState();
    }

    private String firstValidationMessage() {
        return validators.iterator().next().validationMessages().firstMessage();
    }
}
