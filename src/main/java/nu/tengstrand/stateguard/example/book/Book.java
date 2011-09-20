package nu.tengstrand.stateguard.example.book;

public class Book {
    private final BookTitle title;
    private final BookBinding binding;

    Book(BookTitle title, BookBinding binding) {
        this.title = title;
        this.binding = binding;
    }

    public static BookBuilder build() {
        return new BookBuilder();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title +
                "', binding=" + binding +
                '}';
    }
}
