package grx.dod.demo.tp.contracts;

import grx.dod.demo.tp.datastructures.typed.Formes.Espace;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Drawer<T> extends JPanel {

    private static final long serialVersionUID = -4436025711972915033L;

    protected static final Map<String, Color> colors;

    protected transient List<T> formes;
    protected transient T espace;

    protected transient BasicStroke stroke;

    static {
        colors = new HashMap<>();
        colors.put("green", Color.GREEN);
        colors.put("blue", Color.BLUE);
        colors.put("red", Color.RED);
        colors.put("black", Color.BLACK);
        colors.put("magenta", Color.MAGENTA);
        colors.put("pink", Color.PINK);
        colors.put("yellow", Color.YELLOW);
    }




    public Drawer(List<T> formes, T espace) {
        this.formes = formes;
        this.espace = espace;

        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(500, 500));

        this.stroke = new BasicStroke(
                1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f,
                new float[]{2f, 0f, 2f},
                2f
        );
    }
}
