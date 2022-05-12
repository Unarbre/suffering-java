package grx.dod.demo.tp.ihm.components.fields;

import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;

import javax.swing.*;

public class CircleFields {

    private String[] colors = {"green",
            "blue",
            "red",
            "black",
            "magenta",
            "pink",
            "yellow"};

    private NumberField circleX;
    private NumberField circleY;
    private NumberField circleRadius;
    private JComboBox<String> circleColor;

    public CircleFields(JComboBox<String> circleColor, JTextField circleX, JTextField circleY, JTextField circleRadius) {

        this.circleX = new NumberField(circleX, "coordonné X");
        this.circleY = new NumberField(circleY, "coordonné Y");
        this.circleRadius = new NumberField(circleRadius, "Radius du cercle");

        for (String color : colors) {
            circleColor.addItem(color);
        }

        circleColor.setSelectedIndex(0);

        this.circleColor = circleColor;
    }


    public Cercle value() {
        return new Cercle(circleX.value(), circleY.value(), circleRadius.value(), circleColor.getSelectedItem().toString());
    }

    public boolean hasValidFields() {
        return this.circleX.isValid()
                && this.circleY.isValid()
                && this.circleRadius.isValid();
    }

    public void reset() {
        this.circleX.reset();
        this.circleY.reset();
        this.circleRadius.reset();
    }
}
