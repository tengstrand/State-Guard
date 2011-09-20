package nu.tengstrand.stateguard;

public interface Validatable {
    boolean isValid();
    ValidationMessages validationMessages();
}
