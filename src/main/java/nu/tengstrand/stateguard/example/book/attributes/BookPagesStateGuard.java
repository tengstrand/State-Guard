package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.*;
import nu.tengstrand.stateguard.example.book.Pages;

public class BookPagesStateGuard extends StateGuard<BookPages> {
    private final BookPagesValidStateCreator creator = new BookPagesValidStateCreator();

    private static class BookPagesValidStateCreator implements ValidStateCreator<BookPages> {
        Pages pages = new Pages();

        public BookPages createValidState() {
            return new BookPages(pages.value());
        }
    }

    public void setPages(int pages) {
        creator.pages.setValue(pages);
    }

    @Override
    protected Validatable validatable() {
        return creator.pages;
    }

    @Override
    protected ValidStateCreator<BookPages> validStateCreator() {
        return creator;
    }
}
