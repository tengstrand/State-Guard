package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.validator.NonEmptyString;

public class BookTitleStateGuard extends StateGuard<BookTitle> {
    private NonEmptyString title = NonEmptyString.attributeName("title");

    public BookTitleStateGuard() {
        addValidator(title);
    }

    public void setTitle(String title) {
        this.title.withValue(title);
    }

    @Override
    protected BookTitle createValidState() {
        return new BookTitle(title.value());
    }
}
