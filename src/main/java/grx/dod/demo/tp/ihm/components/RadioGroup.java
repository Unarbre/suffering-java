package grx.dod.demo.tp.ihm.components;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class RadioGroup {

    public List<JRadioButton> buttons;
    Runnable changeEvent;

    public RadioGroup(List<JRadioButton> buttons, JRadioButton selected, Runnable onChange) {
        this.buttons = buttons;
        this.changeEvent = onChange;
        this.setupDependentRadiosEvents(buttons);
        selected.setSelected(true);
    }


    public JRadioButton getSelected() {
        return buttons.stream().filter(AbstractButton::isSelected).findFirst().get();
    }

    private void setupDependentRadiosEvents(List<JRadioButton> radios) {
        for (JRadioButton radio : radios) {
            radio.addActionListener(e -> handleDataTypeRadioChanged(
                    radio,
                    radios.stream()
                            .filter(otherRadio -> !otherRadio.equals(radio))
                            .collect(Collectors.toList())));
        }
    }

    private void handleDataTypeRadioChanged(JRadioButton radio, List<JRadioButton> otherRadios) {
        if (radio.isSelected()) {
            for (JRadioButton otherRadio : otherRadios) {
                otherRadio.setSelected(false);
            }
            changeEvent.run();
        }

        if (!radio.isSelected()) {
            radio.setSelected(true);
        }
    }
}