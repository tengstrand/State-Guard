package nu.tengstrand.stateguard.guiexample.person;

public class Name {
    private String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
