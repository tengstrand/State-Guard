package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.validator.NotNull;

public class BookBindingStateGuard extends StateGuard<BookBinding> {
    private NotNull<BookBinding> binding = new NotNull<BookBinding>("binding");

    public BookBindingStateGuard() {
        addValidator(binding);
    }

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
}
