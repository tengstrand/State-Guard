package nu.tengstrand.stateguard.guiexample.person;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.ValidationMessages;
import nu.tengstrand.stateguard.guiexample.ValidatableStringValue;
import nu.tengstrand.stateguard.validator.NonEmptyString;

public class CountryStateGuard extends StateGuard<Country> implements ValidatableStringValue {
    private CountryValidator country = new CountryValidator();

    public CountryStateGuard() {
        addValidator(country);
    }

    public void setValue(String value) {
        country.setValue(value);
    }

    @Override
    protected Country createValidState() {
        return new Country(country.value());
    }

    static class CountryValidator extends NonEmptyString {

        private CountryValidator() {
            super("country");
        }

        @Override
        public boolean isValid() {
            return super.isValid() && ("Sweden".equalsIgnoreCase(value()) || "Norway".equalsIgnoreCase(value()));
        }

        @Override
        public ValidationMessages validationMessages() {
            if (isValid()) {
                return ValidationMessages.withoutMessage();
            }
            if (value() == null || value().length() == 0) {
                return ValidationMessages.message("*");
            }
            return ValidationMessages.message("Valid countries: Sweden, Norway");
        }
    }
}
