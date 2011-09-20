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
            return new ValidationMessages("Invalid!!", new Attribute("x"));
        }
    }

    private static class XStateGuard extends StateGuard<X> {
        private VX vx = new VX();

        @Override
        protected Validatable validatable() {
            return vx;
        }

        @Override
        protected ValidStateCreator<X> validStateCreator() {
            return new ValidStateCreator<X>() {
                public X createValidState() {
                    return new X();
                }
            };
        }
    }

    @Test(expected = ValidateException.class)
    public void test() {
        new XStateGuard().asValidState();
    }
}
