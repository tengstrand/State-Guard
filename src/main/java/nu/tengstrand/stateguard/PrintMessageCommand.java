package nu.tengstrand.stateguard;

public class PrintMessageCommand implements MessageCommand {
    public void execute(String validationMessage) {
        System.out.println(validationMessage);
    }
}
