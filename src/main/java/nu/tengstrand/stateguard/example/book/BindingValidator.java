package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationMessage;
import nu.tengstrand.stateguard.ValidationMessages;
import nu.tengstrand.stateguard.example.book.attributes.BookBindingStateGuard;
import nu.tengstrand.stateguard.example.book.attributes.BookPagesStateGuard;

public class BindingValidator implements Validatable {
    private final BookPagesStateGuard pages;
    private final BookBindingStateGuard binding;

    public BindingValidator(BookPagesStateGuard pages, BookBindingStateGuard binding) {
        this.pages = pages;
        this.binding = binding;
    }

    /**
     * This validation is only performed if both 'pages' and 'binding' is valid.
     *
     * @return false if binding is paperback and number of pages > 2000, otherwise true
     */
    public boolean isValid() {
        if (!pages.isValid() || !binding.isValid() || !binding.isPaperback())
            return true;

        return pages.asValidState().value() <= 2000;
    }

    public ValidationMessages validationMessages() {
        if (isValid())
            return ValidationMessages.withoutMessage();

        return ValidationMessages.add(ValidationMessage.message("Paperback books can not have more than 2000 pages, but was {0} pages").arguments(pages.asValidState().value()));
    }
}
