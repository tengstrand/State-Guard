package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.Attributes;
import nu.tengstrand.stateguard.AttributesStateGuard;
import nu.tengstrand.stateguard.ValidStateCreator;
import nu.tengstrand.stateguard.example.book.attributes.BookBinding;

public class BookCreator extends AttributesStateGuard<Book> {
    private BookAttributes attributes = new BookAttributes();
    private ValidStateCreator<Book> stateCreator = new ValidStateCreator<Book>() {
        public Book createValidState() {
            return new Book(attributes.title.asValidState(), attributes.binding.asValidState(), attributes.pages.asValidState());
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
        public Pages paperback() {
            attributes.binding.setBinding(BookBinding.PAPERBACK);
            return new Pages();
        }
        public Pages hardback() {
            attributes.binding.setBinding(BookBinding.HARDBACK);
            return new Pages();
        }
    }

    public class Pages {
        public BookCreator pages(int pages) {
            attributes.pages.setPages(pages);
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
