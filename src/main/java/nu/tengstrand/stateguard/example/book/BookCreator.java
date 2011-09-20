package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.Attributes;
import nu.tengstrand.stateguard.AttributesStateGuard;
import nu.tengstrand.stateguard.ValidStateCreator;

public class BookCreator extends AttributesStateGuard<Book> {
    private BookAttributes attributes = new BookAttributes();
    private ValidStateCreator<Book> stateCreator = new ValidStateCreator<Book>() {
        public Book createValidState() {
            return new Book(attributes.title.asValidState(), attributes.binding.asValidState());
        }
    };

    BookCreator() {
    }

    public class Title {
        public Binding title(String title) {
            attributes.title.setTitle(title);
            return new Binding();
        }
    }

    public class Binding {
        public BookCreator paperback() {
            attributes.binding.setBinding(BookBinding.PAPERBACK);
            return BookCreator.this;
        }
        public BookCreator hardback() {
            attributes.binding.setBinding(BookBinding.HARDBACK);
            return BookCreator.this;
        }
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
