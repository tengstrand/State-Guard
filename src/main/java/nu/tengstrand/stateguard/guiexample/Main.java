package nu.tengstrand.stateguard.guiexample;

import nu.tengstrand.stateguard.guiexample.person.Person;
import nu.tengstrand.stateguard.guiexample.person.PersonStateGuard;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final PersonStateGuard personStateGuard = new PersonStateGuard();

                new PersonFrame(personStateGuard, new SaveCommand() {
                    public void save() {
                        Person person = personStateGuard.asValidState();
                        new PopupFrame(person);
                   }
                });
            }
        });
    }
}