package nu.tengstrand.stateguard.guiexample.person;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.guiexample.ValidatableStringValue;
import nu.tengstrand.stateguard.validator.NonEmptyString;

public class NameStateGuard extends StateGuard<Name> implements ValidatableStringValue {
    private NonEmptyString name = NonEmptyString.attributeName("name").messageKey("mandatory.field");

    public NameStateGuard() {
        addValidator(name);
    }

    public void setValue(String value) {
        name.setValue(value);
    }

    @Override
    protected Name createValidState() {
        return new Name(name.value());
    }
}
