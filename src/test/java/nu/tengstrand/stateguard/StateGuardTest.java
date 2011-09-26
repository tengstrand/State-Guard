package nu.tengstrand.stateguard;

import org.junit.Test;

public class StateGuardTest {

    private static class X {
    }

    private static class ValidXValidator implements Validatable {
        public boolean isValid() {
            return true;
        }
        public ValidationMessages validationMessages() {
            return ValidationMessages.withoutMessage();
        }
    }

    private static class InvalidXValidator implements Validatable {
        public boolean isValid() {
            return false;
        }
        public ValidationMessages validationMessages() {
            return ValidationMessages.message("Invalid!!");
        }
    }

    private static class ValidXStateGuard extends StateGuard<X> {
        private Validatable validator = new ValidXValidator();

        public ValidXStateGuard() {
            addValidator(validator);
        }

        @Override
        protected X createValidState() {
            return new X();
        }
    }

    private static class InvalidXStateGuard extends StateGuard<X> {
        private Validatable validator = new InvalidXValidator();

        public InvalidXStateGuard() {
            addValidator(validator);
        }

        @Override
        protected X createValidState() {
            return new X();
        }
    }

    @Test
    public void validState() {
        new ValidXStateGuard().asValidState();
    }

    @Test(expected = ValidateException.class)
    public void invalidState() {
        new InvalidXStateGuard().asValidState();
    }
}
