package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.*;
import nu.tengstrand.stateguard.example.book.attributes.BookBinding;

public class BookBuilder extends AttributesStateGuard<Book> {
    private BookAttributes attributes = new BookAttributes();

    BookBuilder() {
    }

    public BookBuilder title(String title) {
        attributes.title.setTitle(title);
        return this;
    }

    public BookBuilder binding(BookBinding binding) {
        attributes.binding.setBinding(binding);
        return this;
    }

    public BookBuilder pages(int pages) {
        attributes.pages.setPages(pages);
        return this;
    }

    @Override
    protected Attributes attributes() {
        return attributes;
    }

    @Override
    protected Book createValidState() {
        return new Book(attributes.title.asValidState(), attributes.binding.asValidState(), attributes.pages.asValidState());
    }
}
