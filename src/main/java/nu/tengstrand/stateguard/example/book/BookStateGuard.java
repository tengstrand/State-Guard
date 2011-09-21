package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.example.book.attributes.BookBindingStateGuard;
import nu.tengstrand.stateguard.example.book.attributes.BookPagesStateGuard;
import nu.tengstrand.stateguard.example.book.attributes.BookTitleStateGuard;

public abstract class BookStateGuard extends StateGuard<Book> {
    protected BookTitleStateGuard title = new BookTitleStateGuard();
    protected BookBindingStateGuard binding = new BookBindingStateGuard();
    protected BookPagesStateGuard pages = new BookPagesStateGuard();

    public BookStateGuard() {
        addValidators(title, binding, pages);
    }

    @Override
    protected Book createValidState() {
        return new Book(title.asValidState(), binding.asValidState(), pages.asValidState());
    }
}
