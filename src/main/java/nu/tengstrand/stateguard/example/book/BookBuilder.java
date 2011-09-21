package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.example.book.attributes.BookBinding;

public class BookBuilder extends BookStateGuard {
    BookBuilder() {
    }

    public BookBuilder title(String title) {
        this.title.setTitle(title);
        return this;
    }

    public BookBuilder binding(BookBinding binding) {
        this.binding.setBinding(binding);
        return this;
    }

    public BookBuilder pages(int pages) {
        this.pages.setPages(pages);
        return this;
    }
}
