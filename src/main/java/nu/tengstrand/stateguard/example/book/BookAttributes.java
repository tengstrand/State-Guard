package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.Attributes;

public class BookAttributes extends Attributes {
    public BookTitleStateGuard title = new BookTitleStateGuard();
    public BookBindingStateGuard binding = new BookBindingStateGuard();

    public BookAttributes() {
        addAttributes(title, binding);
    }
}
