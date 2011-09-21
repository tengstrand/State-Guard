package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.ValidationId;
import nu.tengstrand.stateguard.validator.NonEmptyString;

public class BookTitleStateGuard extends StateGuard<BookTitle> {
    private NonEmptyString title = new NonEmptyString(new ValidationId("title"));

    public BookTitleStateGuard() {
        addValidator(title);
    }

    public void setTitle(String title) {
        this.title.setValue(title);
    }

    @Override
    protected BookTitle createValidState() {
        return new BookTitle(title.value());
    }
}
