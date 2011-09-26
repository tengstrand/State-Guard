package nu.tengstrand.stateguard;

import org.junit.Test;

public class StateGuardTest {

    private static class X {
    }

    private static class XValidator implements Validatable {
        public boolean isValid() {
            return false;
        }
        public ValidationMessages validationMessages() {
            return ValidationMessages.message("Invalid!!");
        }
    }

    private static class XStateGuard extends StateGuard<X> {
        private XValidator XValidator = new XValidator();

        public XStateGuard() {
            addValidator(XValidator);
        }

        @Override
        protected X createValidState() {
            return new X();
        }
    }

    @Test(expected = ValidateException.class)
    public void test() {
        new XStateGuard().asValidState();
    }
}
