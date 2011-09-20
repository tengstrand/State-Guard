package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.ValidStateCreator;
import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.validator.NonEmptyString;

public class BookTitleStateGuard extends StateGuard<BookTitle> {
    private final BookTitleValidStateCreator creator = new BookTitleValidStateCreator();

    private static class BookTitleValidStateCreator implements ValidStateCreator<BookTitle> {
        NonEmptyString title = new NonEmptyString("title");

        public BookTitle createValidState() {
            return new BookTitle(title.value());
        }
    }

    public void setTitle(String title) {
        creator.title.setValue(title);
    }

    @Override
    protected Validatable validatable() {
        return creator.title;
    }

    @Override
    protected ValidStateCreator<BookTitle> validStateCreator() {
        return creator;
    }
}
