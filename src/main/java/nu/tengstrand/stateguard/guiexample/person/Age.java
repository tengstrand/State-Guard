package nu.tengstrand.stateguard.guiexample.person;

public class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.valueOf(age);
    }
}
