package nu.tengstrand.stateguard;

public class ValidationMessage {
    public final Object id;
    public final String message;

    public ValidationMessage(String message, Object id) {
        this.message = message;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationMessage that = (ValidationMessage) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ValidationMessage{id=" + id +
                ", message=" + message + "}";
    }
}
