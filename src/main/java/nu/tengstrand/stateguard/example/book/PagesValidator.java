package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessages;

public class PagesValidator implements Validatable {
    private int pages = 0;

    public int value() {
        return pages;
    }

    public void setValue(int pages) {
        this.pages = pages;
    }

    public boolean isValid() {
        return pages > 0 && (pages % 2) == 0;
    }

    public ValidationMessages validationMessages() {
        if (pages <= 0) {
            return new ValidationMessages("Attribute 'pages' must be greater than zero, but was " + pages, BookValidator.PAGES);
        } else if ((pages % 2) != 0){
            return new ValidationMessages("Attribute 'pages' (" + pages + ") must be an even number", BookValidator.PAGES);
        }
        return new ValidationMessages();
    }
}
