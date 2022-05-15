package grx.dod.demo.tp.ihm.components.fields;

import javax.swing.*;

public class AmountField {

    private final JComboBox<Integer> values;

    private final Runnable onChange;

    public AmountField(final JComboBox<Integer> values, Runnable onChange) {
        this.values = values;
        this.onChange = onChange;
        this.setValues();
    }

    private void setValues() {
        for (int i = 1; i < 40; i++) {
            this.values.addItem(i);
        }

        this.values.setSelectedIndex(1);
        this.values.addActionListener(e -> onChange.run());
    }

    public int getValue() {
        return this.values.getSelectedIndex() + 1;
    }
}
