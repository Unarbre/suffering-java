package grx.dod.demo.tp.ihm.components.fields;

import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;

import javax.swing.*;

public class RectangleFields {

    private String[] colors = {"green",
            "blue",
            "red",
            "black",
            "magenta",
            "pink",
            "yellow"};

    private JComboBox<String> color;
    private NumberField x;
    private NumberField y;
    private NumberField width;
    private NumberField height;

    public RectangleFields(JComboBox<String> colorsCb, JTextField x, JTextField y, JTextField width, JTextField height) {
        this.x = new NumberField(x, "Coordonné X");
        this.y = new NumberField(y, "Coordonné Y");
        this.width = new NumberField(width, "Largeur");
        this.height = new NumberField(height, "Hauteur");

        for (String colore : colors) {
            colorsCb.addItem(colore);
        }

        colorsCb.setSelectedIndex(0);

        this.color = colorsCb;
    }

    public boolean hasValidFields() {
        return x.isValid()
                && y.isValid()
                && width.isValid()
                && height.isValid();
    }

    public Rectangle value() {
        return new Rectangle(x.value(), y.value(), width.value(), height.value(), color.getSelectedItem().toString());
    }

    public void reset() {
        x.reset();
        y.reset();
        width.reset();
        height.reset();
    }


//    public List<>
}
