package nu.tengstrand.stateguard;

public class ValidationId {
    public final Object id;

    public ValidationId(Object id) {
        if (id == null) {
            throw new IllegalStateException("Validation id can not be null");
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationId that = (ValidationId) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
