package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.*;

public class BookBuilder extends AttributesStateGuard<Book> {
    private BookAttributes attributes = new BookAttributes();
    private ValidStateCreator<Book> stateCreator = new ValidStateCreator<Book>() {
        public Book createValidState() {
            return new Book(attributes.title.asValidState(), attributes.binding.asValidState());
        }
    };

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

    @Override
    protected Attributes attributes() {
        return attributes;
    }

    @Override
    protected ValidStateCreator<Book> validStateCreator() {
        return stateCreator;
    }
}
