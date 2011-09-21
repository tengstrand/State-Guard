package nu.tengstrand.stateguard.example.book;

import nu.tengstrand.stateguard.example.book.attributes.BookBinding;

public class BookCreator extends BookStateGuard {
    BookCreator() {
    }

    public class Title {
        public Binding title(String title) {
            BookCreator.this.title.setTitle(title);
            return new Binding();
        }
    }

    public class Binding {
        public Pages paperback() {
            BookCreator.this.binding.setBinding(BookBinding.PAPERBACK);
            return new Pages();
        }
        public Pages hardback() {
            BookCreator.this.binding.setBinding(BookBinding.HARDBACK);
            return new Pages();
        }
    }

    public class Pages {
        public BookCreator pages(int pages) {
            BookCreator.this.pages.setPages(pages);
            return BookCreator.this;
        }
    }
}
