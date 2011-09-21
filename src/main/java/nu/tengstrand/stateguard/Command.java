package nu.tengstrand.stateguard;

public interface Command {
    void execute(ValidationMessage validationMessage);
}
