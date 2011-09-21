package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.ValidationId;
import nu.tengstrand.stateguard.validator.NotNull;

public class BookBindingStateGuard extends StateGuard<BookBinding> {
    private NotNull<BookBinding> binding = new NotNull<BookBinding>(new ValidationId("binding"));

    public void setBinding(BookBinding binding) {
        this.binding.setValue(binding);
    }

    public boolean isPaperback() {
        return binding.value() == BookBinding.PAPERBACK;
    }

    @Override
    public BookBinding createValidState() {
        return binding.value();
    }

    @Override
    protected Validatable validatable() {
        return binding;
    }
}
