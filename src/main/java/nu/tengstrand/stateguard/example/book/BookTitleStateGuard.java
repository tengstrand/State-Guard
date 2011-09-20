package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.ValidStateCreator;
import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.validator.NotNull;

public class BookTitleStateGuard extends StateGuard<BookTitle>{
    private final BookTitleValidStateCreator creator = new BookTitleValidStateCreator();

    private static class BookTitleValidStateCreator implements ValidStateCreator<BookTitle> {
        NotNull<String> title = new NotNull<String>("title");

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
