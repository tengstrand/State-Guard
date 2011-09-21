package nu.tengstrand.stateguard;

public interface ValidationCommand {
    void execute(ValidationMessage validationMessage);
}
