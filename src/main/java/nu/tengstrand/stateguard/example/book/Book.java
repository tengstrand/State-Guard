package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.example.book.attributes.BookBinding;
import nu.tengstrand.stateguard.example.book.attributes.BookPages;
import nu.tengstrand.stateguard.example.book.attributes.BookTitle;

public class Book {
    private final BookTitle title;
    private final BookBinding binding;
    private final BookPages pages;

    Book(BookTitle title, BookBinding binding, BookPages pages) {
        this.title = title;
        this.binding = binding;
        this.pages = pages;
    }

    public static BookBuilder build() {
        return new BookBuilder();
    }

    public static BookCreator.Title create() {
        return new BookCreator().new Title();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title +
                "', binding=" + binding +
                ", pages=" + pages +
                '}';
    }
}
