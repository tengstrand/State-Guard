package nu.tengstrand.stateguard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Attributes implements Validatable, Iterable<Validatable> {
    private List<Validatable> validatables = new ArrayList<Validatable>();

    public Attributes(Validatable... validatables) {
        addAttributes(validatables);
    }

    public void addAttributes(Validatable... validatables) {
        this.validatables.addAll(Arrays.asList(validatables));
    }

    public boolean isValid() {
        for (Validatable validatable : validatables) {
            if (!validatable.isValid()) {
                return false;
            }
        }
        return true;
    }

    public ValidationMessages validationMessages() {
        ValidationMessages validationMessages = new ValidationMessages();
        for (Validatable validatable : validatables) {
            if (!validatable.isValid()) {
                validationMessages = validationMessages.createMessages(validatable.validationMessages());
            }
        }
        return validationMessages;
    }

    public Iterator<Validatable> iterator() {
        return validatables.iterator();
    }
}
