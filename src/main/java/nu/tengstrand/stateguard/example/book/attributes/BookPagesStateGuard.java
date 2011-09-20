package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.*;
import nu.tengstrand.stateguard.example.book.PagesValidator;

public class BookPagesStateGuard extends StateGuard<BookPages> {
    private final BookPagesValidStateCreator creator = new BookPagesValidStateCreator();

    private static class BookPagesValidStateCreator implements ValidStateCreator<BookPages> {
        PagesValidator pages = new PagesValidator();

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
