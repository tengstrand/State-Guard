package nu.tengstrand.stateguard.guiexample.person;

public class Country {
    private String country;

    public Country(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return country;
    }
}
