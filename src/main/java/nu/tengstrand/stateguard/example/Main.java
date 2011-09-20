package nu.tengstrand.stateguard.example;

import nu.tengstrand.stateguard.example.book.Book;
import nu.tengstrand.stateguard.example.book.BookBinding;
import nu.tengstrand.stateguard.example.book.BookBuilder;

public class Main {

    public static void main(String[] args) {
        BookBuilder bookBuilder = Book.build().title("My Book");
        System.out.println("Valid: " + bookBuilder.isValid());
        System.out.println("Valildation messages: " + bookBuilder.validationMessages());

        bookBuilder.binding(BookBinding.PAPERBACK);
        Book book = bookBuilder.asValidState();
        System.out.println("Book: " + book);
    }
}
