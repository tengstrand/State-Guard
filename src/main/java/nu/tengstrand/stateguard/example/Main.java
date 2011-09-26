package nu.tengstrand.stateguard.example;

import nu.tengstrand.stateguard.example.book.Book;
import nu.tengstrand.stateguard.example.book.BookStateGuard;
import nu.tengstrand.stateguard.example.book.attributes.BookBinding;
import nu.tengstrand.stateguard.example.book.BookBuilder;
import nu.tengstrand.stateguard.example.book.BookCreator;

import java.util.ResourceBundle;

public class Main {
    static ResourceBundle resourceBundle = ResourceBundle.getBundle("validationMessages");

    public static void main(String[] args) {
        System.out.println("----- Build: Missing attributes ------");
        BookBuilder bookBuilder = Book.build().title("My Book");
        printValidationMessages(bookBuilder);

        System.out.println("\n----- Build: With binding + pages ------");
        bookBuilder.binding(BookBinding.PAPERBACK).pages(50);
        printValidationMessages(bookBuilder);
        Book bookWithMissingBinding = bookBuilder.asValidState();
        System.out.println("Book: " + bookWithMissingBinding);

        System.out.println("\n----- Create: Empty title ------");
        BookCreator bookCreatorWithEmptyTitle = Book.create().title("").paperback().pages(100);
        printValidationMessages(bookCreatorWithEmptyTitle);

        System.out.println("\n----- Create: Thick book ------");
        BookCreator thickBookCreator = Book.create().title("Thick book").paperback().pages(3000);
        printValidationMessages(thickBookCreator);

        System.out.println("\n----- Create: Valid book ------");
        BookCreator bookCreator = Book.create().title("The book").paperback().pages(200);
        printValidationMessages(bookCreator);
        Book book = bookCreator.asValidState();
        System.out.println("Book: " + book);
    }

    private static void printValidationMessages(BookStateGuard stateGuard) {
        System.out.println("Valid=" + stateGuard.isValid());
        for (String formattedMessage : stateGuard.formattedValidationMessages(resourceBundle)) {
            System.out.println(formattedMessage);
        }
    }
}
