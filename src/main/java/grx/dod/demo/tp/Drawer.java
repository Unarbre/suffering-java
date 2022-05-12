package grx.dod.demo.tp;

import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;
import grx.dod.demo.tp.datastructures.simplified.Graphical.FormsDisplayer;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Graphical.TypedDraw;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Drawer {

    JFrame window;

    public Drawer() {

    }


    public void draw(List<Forme> formes, Forme espace) {
        if (window != null) {
            window.setVisible(false);
        }
        window = new JFrame("Espace d'occupation des formes");
        window.setLayout(new BorderLayout());
        window.add(new TypedDraw(formes, espace), BorderLayout.CENTER);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
