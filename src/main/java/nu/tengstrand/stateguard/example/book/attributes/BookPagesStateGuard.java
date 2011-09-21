package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.*;
import nu.tengstrand.stateguard.example.book.PagesValidator;

public class BookPagesStateGuard extends StateGuard<BookPages> {
    private PagesValidator pages = new PagesValidator();

    public void setPages(int pages) {
        this.pages.setValue(pages);
    }

    @Override
    protected Validatable validatable() {
        return pages;
    }

    @Override
    protected BookPages createValidState() {
        return new BookPages(pages.value());
    }
}
