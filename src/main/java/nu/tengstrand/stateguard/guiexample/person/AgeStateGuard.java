package nu.tengstrand.stateguard.guiexample.person;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.ValidationMessages;
import nu.tengstrand.stateguard.guiexample.ValidatableStringValue;
import nu.tengstrand.stateguard.validator.IntegerValidator;

public class AgeStateGuard extends StateGuard<Age> implements ValidatableStringValue {
    private AgeValidator age = new AgeValidator();

    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 150;

    public AgeStateGuard() {
        addValidator(age);
    }

    public void setValue(String value) {
        age.setValue(value);
    }

    @Override
    protected Age createValidState() {
        return new Age(age.value());
    }


    private static class AgeValidator extends IntegerValidator {
        AgeValidator() {
            super("age");
        }

        @Override
        public boolean isValid() {
            return super.isValid() && value() >= MIN_AGE && value() <= MAX_AGE;
        }

        @Override
        public ValidationMessages validationMessages() {
            if (isValid()) {
                return ValidationMessages.withoutMessage();
            }
            if (stringValue() == null || stringValue().length() == 0) {
                return ValidationMessages.message("*");
            }
            return ValidationMessages.message("Enter a valid age");
        }
    }
}
