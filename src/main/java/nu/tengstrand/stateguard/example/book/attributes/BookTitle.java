package nu.tengstrand.stateguard.example.book.attributes;

public class BookTitle {
    private final String title;

    BookTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
