package grx.dod.demo.tp.ihm.components.fields;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class NumberField {

    private final JTextField field;

    private String previousValue = "";

    private String placeholder;

    public NumberField(JTextField field, String placeholder) {
        this.field = field;
        this.placeholder = placeholder;
        this.field.setText(placeholder);
        this.field.addKeyListener(new OnlyNumberConstraintListener());
        this.field.addFocusListener(new PlaceHolderFocusListener());
    }

    public int value() {
        return Integer.parseInt(this.field.getText());
    }

    public void reset() {
        this.field.setText(placeholder);
    }

    public boolean isValid() {
        return !this.field.getText().isEmpty() && !this.field.getText().equals(placeholder);
    }

    private class OnlyNumberConstraintListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try {
                boolean isNegativeMarker = Objects.equals(field.getText(), "-");
                if (!isNegativeMarker) {
                    Integer.parseInt(field.getText());
                }
            } catch (Exception exception) {
                field.setText(previousValue);
            }

            previousValue = field.getText();

        }
    }

    private class PlaceHolderFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            if (field.getText().equals(placeholder)) {
                field.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (field.getText().isEmpty()) {
                field.setText(placeholder);
            }
        }

    }
}
