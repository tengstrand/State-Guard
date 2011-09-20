package nu.tengstrand.stateguard.example;

import nu.tengstrand.stateguard.Validatable;
import nu.tengstrand.stateguard.example.book.Book;
import nu.tengstrand.stateguard.example.book.BookBinding;
import nu.tengstrand.stateguard.example.book.BookBuilder;
import nu.tengstrand.stateguard.example.book.BookCreator;

public class Main {

    public static void main(String[] args) {
        System.out.println("----- Build: Missing binding ------");
        BookBuilder bookBuilder = Book.build().title("My Book");
        printMessage(bookBuilder);

        System.out.println("----- Build: With binding = PAPERBACK ------");
        bookBuilder.binding(BookBinding.PAPERBACK);
        printMessage(bookBuilder);
        Book bookWithMissingBinding = bookBuilder.asValidState();
        System.out.println("Book: " + bookWithMissingBinding);

        System.out.println("----- Create: Empty title ------");
        BookCreator bookCreatorWithEmptyTitle = Book.create().title("").paperback();
        printMessage(bookCreatorWithEmptyTitle);

        System.out.println("----- Create: Valid book ------");
        BookCreator bookCreator = Book.create().title("The book").paperback();
        printMessage(bookCreator);
        Book book = bookCreator.asValidState();
        System.out.println("Book: " + book);
    }

    public static void printMessage(Validatable validatable) {
        System.out.println("valid = " + validatable.isValid() + ", message = " + validatable.validationMessages());
    }
}
