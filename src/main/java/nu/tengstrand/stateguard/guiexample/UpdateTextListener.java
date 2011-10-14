package nu.tengstrand.stateguard.guiexample;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

public abstract class UpdateTextListener implements DocumentListener {
    public abstract void setText(String text);

    public void insertUpdate(DocumentEvent documentEvent) {
        setText(documentEvent);
    }

    public void removeUpdate(DocumentEvent documentEvent) {
        setText(documentEvent);
    }

    public void changedUpdate(DocumentEvent documentEvent) {
        setText(documentEvent);
    }

    private void setText(DocumentEvent e) {
        try {
            setText(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException e1) {
            setText("");
        }
    }
}
