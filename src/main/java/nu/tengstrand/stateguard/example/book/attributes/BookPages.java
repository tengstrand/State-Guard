package nu.tengstrand.stateguard.example.book.attributes;

public class BookPages {
    private final int pages;

    BookPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return String.valueOf(pages);
    }
}
