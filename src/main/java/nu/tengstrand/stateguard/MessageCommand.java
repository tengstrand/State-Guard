package nu.tengstrand.stateguard;

public interface MessageCommand {
    void execute(String validationMessage);
}
