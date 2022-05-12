package grx.dod.demo.tp.datastructures.simplified.Graphical;

import grx.dod.demo.tp.datastructures.contracts.Drawer;
import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class FormsDisplayer extends Drawer<SimplifiedForme> {

    public FormsDisplayer(List<SimplifiedForme> formes, SimplifiedForme espace) {
        super(formes, espace);
    }

    @Override
    public void paint(Graphics g) {
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
            for (SimplifiedForme forme : formes) {
                g2d.setColor(colors.get(forme.color));
                if (forme.type.equals("Cercle")){
                    g2d.fill(
                            new Ellipse2D.Double(
                                    zX + forme.x - forme.radius * unity,
                                    zY + forme.y - forme.radius * unity,
                                    forme.radius * 2 * unity,
                                    forme.radius * 2 * unity
                            )
                    );
                }

                if (forme.type.equals("Rectangle")){
                    g2d.fill(
                            new Rectangle2D.Double(
                                    zX + forme.x * unity,
                                    zY + forme.y * unity,
                                    forme.width * unity,
                                    forme.height * unity
                            )
                    );
                }
            }

            if (espace != null) {
                g2d.setColor(Color.BLACK);
                g2d.setStroke(stroke);
                g2d.draw(
                        new Rectangle2D.Double(
                                zX + espace.x * unity,
                                zY + espace.y * unity,
                                espace.width * unity,
                                espace.height * unity
                        )
                );
            }
        }
    }
}
