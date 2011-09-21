package nu.tengstrand.stateguard;

import org.junit.Test;

public class StateGuardTest {

    private static class X {
    }

    private static class VX implements Validatable {
        public boolean isValid() {
            return false;
        }
        public ValidationMessages validationMessages() {
            return new ValidationMessages("Invalid!!", new ValidationId("x"));
        }
    }

    private static class XStateGuard extends StateGuard<X> {
        private VX vx = new VX();

        public XStateGuard() {
            addValidator(vx);
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
