package nu.tengstrand.stateguard.guiexample.person;

public class Person {
    private Name name;
    private Age age;
    private Country country;

    public Person(Name name, Age age, Country country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + "'" +
                ", age=" + age +
                ", country='" + country + "'" +
                '}';
    }
}
