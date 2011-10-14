package nu.tengstrand.stateguard.guiexample.person;

import nu.tengstrand.stateguard.StateGuard;

public class PersonStateGuard extends StateGuard<Person> {
    private NameStateGuard name = new NameStateGuard();
    private AgeStateGuard age = new AgeStateGuard();
    private CountryStateGuard country = new CountryStateGuard();

    public NameStateGuard name() { return name; }
    public AgeStateGuard age() { return age; }
    public CountryStateGuard country() { return country; }

    public PersonStateGuard() {
        addValidators(name,  age, country);
    }

    @Override
    protected Person createValidState() {
        return new Person(name.asValidState(), age.asValidState(), country.asValidState());
    }
}
