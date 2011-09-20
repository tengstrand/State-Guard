package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.Attributes;
import nu.tengstrand.stateguard.example.book.attributes.BookBindingStateGuard;
import nu.tengstrand.stateguard.example.book.attributes.BookPagesStateGuard;
import nu.tengstrand.stateguard.example.book.attributes.BookTitleStateGuard;

public class BookAttributes extends Attributes {
    public BookTitleStateGuard title = new BookTitleStateGuard();
    public BookBindingStateGuard binding = new BookBindingStateGuard();
    public BookPagesStateGuard pages = new BookPagesStateGuard();

    public BookAttributes() {
        addAttributes(title, binding, pages);
    }
}
