package nu.tengstrand.stateguard.example.book.attributes;

import nu.tengstrand.stateguard.StateGuard;
import nu.tengstrand.stateguard.ValidStateCreator;
import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.validator.NotNull;

public class BookBindingStateGuard extends StateGuard<BookBinding> {
    private final BookTitleValidStateCreator creator = new BookTitleValidStateCreator();

    private static class BookTitleValidStateCreator implements ValidStateCreator<BookBinding> {
        NotNull<BookBinding> binding = new NotNull<BookBinding>("binding");

        public BookBinding createValidState() {
            return binding.value();
        }
    }

    public void setBinding(BookBinding binding) {
        creator.binding.setValue(binding);
    }

    public boolean isPaperback() {
        return creator.binding.value() == BookBinding.PAPERBACK;
    }

    @Override
    protected Validatable validatable() {
        return creator.binding;
    }

    @Override
    protected ValidStateCreator<BookBinding> validStateCreator() {
        return creator;
    }
}
