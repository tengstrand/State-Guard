package nu.tengstrand.stateguard.example.book.attributes;

public class BookTitle {
    private String title;

    public BookTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
