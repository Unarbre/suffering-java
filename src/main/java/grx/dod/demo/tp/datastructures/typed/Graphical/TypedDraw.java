package grx.dod.demo.tp.datastructures.typed.Graphical;

import grx.dod.demo.tp.datastructures.contracts.Drawer;
import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;
import grx.dod.demo.tp.datastructures.typed.Formes.Espace;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class TypedDraw extends Drawer<Forme> {


    public TypedDraw(List<Forme> formes, Forme espace) {
        super(formes, espace);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int dW = this.getWidth();
        int dH = this.getHeight();

        int zX = (dW / 2);
        int zY = (dH / 2);
        int mX = (zX * 2);
        int mY = (zY * 2);

        int unity = 25;

        // Afficher le fond
        super.paintComponent(g2d);

        // Afficher l'axe (en gris)
        g2d.setColor(Color.GRAY);
        g2d.draw(new Line2D.Double(0, zY, mX, zY));
        g2d.draw(new Line2D.Double(zX, 0, zX, mY));

        if (formes != null) {
            for (Forme forme : formes) {
                g2d.setColor(colors.get(forme.color));
                if (forme instanceof Cercle) {
                    Cercle cercle = (Cercle) forme;
                    g2d.fill(
                            new Ellipse2D.Double(
                                    zX + (cercle.x - cercle.rayon) * unity, zY + (cercle.y - cercle.rayon) * unity,
                                    cercle.rayon * 2 * unity, cercle.rayon * 2 * unity
                            )
                    );
                } else if (forme instanceof Rectangle) {
                    Rectangle rect = (Rectangle) forme;
                    g2d.fill(
                            new Rectangle2D.Double(
                                    zX + rect.x * unity, zY + rect.y * unity,
                                    rect.width * unity, rect.height * unity
                            )
                    );
                }
            }
        }

        if (espace != null) {
            Espace sEspace = (Espace) espace;
            g2d.setColor(Color.BLACK);
            g2d.setStroke(stroke);
            g2d.draw(
                    new Rectangle2D.Double(
                            zX + sEspace.x * unity, zY + sEspace.y * unity,
                            sEspace.width * unity, sEspace.height * unity
                    )
            );
        }
    }

}
