package grx.dod.demo.tp;

import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;
import grx.dod.demo.tp.datastructures.simplified.Graphical.FormsDisplayer;
import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;
import grx.dod.demo.tp.datastructures.typed.Formes.Espace;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;
import grx.dod.demo.tp.datastructures.typed.Graphical.TypedDraw;
import grx.dod.demo.tp.datastructures.typed.Manipulations.TypedConversion;
import grx.dod.demo.tp.datastructures.typed.Manipulations.TypedEspaceCalculator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Drawer {

    JFrame window;

    public Espace calculEspace(List<Forme> formes) {
        List<Forme> rects = new ArrayList<>();
        TypedConversion typedConversion = new TypedConversion();

        for (Forme forme : formes) {
            if (forme instanceof Rectangle) {
                // Rien à faire
                rects.add(forme);
            } else if (forme instanceof Cercle) {
                // Conversion à faire
                rects.add(typedConversion.apply(forme));
            }
        }

        TypedEspaceCalculator espace = new TypedEspaceCalculator();

        return (Espace) espace.output(rects).get(0);
    }


    public void draw(List<Forme> formes) {
        if (window != null) {
            window.setVisible(false);
        }
        window = new JFrame("Espace d'occupation des formes");
        window.setLayout(new BorderLayout());
        window.add(new TypedDraw(formes, calculEspace(formes)), BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
