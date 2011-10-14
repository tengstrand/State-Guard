package nu.tengstrand.stateguard.guiexample;

import nu.tengstrand.stateguard.guiexample.person.Person;

import javax.swing.*;
import java.awt.*;

public class PopupFrame extends JFrame {

    public PopupFrame(Person person) throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Result");

        setPreferredSize(new Dimension(320, 60));
        setLocation(100, 50);

        JLabel personText = new JLabel(person.toString());
        getContentPane().add(personText);

        setVisible(true);
        pack();
    }
}
