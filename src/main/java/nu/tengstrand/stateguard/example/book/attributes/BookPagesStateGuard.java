package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.*;
import nu.tengstrand.stateguard.example.book.PagesValidator;

public class BookPagesStateGuard extends StateGuard<BookPages> {
    private PagesValidator pages = new PagesValidator();

    public BookPagesStateGuard() {
        addValidator(pages);
    }

    public void setPages(int pages) {
        this.pages.setValue(pages);
    }

    @Override
    protected BookPages createValidState() {
        return new BookPages(pages.value());
    }
}
