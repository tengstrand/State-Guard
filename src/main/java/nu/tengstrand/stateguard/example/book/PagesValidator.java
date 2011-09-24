package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessage;
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
            return ValidationMessages.message("Attribute ''pages'' must be greater than zero, but was {0}").arguments(pages);
        } else if ((pages % 2) != 0){
            return ValidationMessages.message("Attribute ''pages'' must be an even number, but was {0}").arguments(pages);
        }
        return ValidationMessages.withoutMessage();
    }
}
