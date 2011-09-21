package nu.tengstrand.stateguard.example;

import nu.tengstrand.stateguard.ValidationCommand;
import nu.tengstrand.stateguard.ValidationMessage;
import nu.tengstrand.stateguard.example.book.BookValidator;

public class BookValidationCommand implements ValidationCommand {

    public void execute(ValidationMessage validationMessage) {
        if (validationMessage.id == BookValidator.TITLE) {
            System.out.println("....do something with this validation error!");
        }
    }
}
