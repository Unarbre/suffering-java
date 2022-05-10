package grx.dod.demo.tp.datastructures.typed.Manipulations;

import grx.dod.demo.tp.contracts.Conversion;
import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;

public class TypedConversion implements Conversion<Forme> {

    @Override
    public Rectangle apply(Forme forme) {
        if (forme instanceof Rectangle) {
            return (Rectangle) forme;
        } else if (forme instanceof Cercle) {
            Cercle cercle = (Cercle) forme;
            double rayon = cercle.rayon;
            double x = cercle.x - rayon;
            double y = cercle.y - rayon;
            double width = rayon * 2;
            double height = rayon * 2;

            return new Rectangle(x, y, width, height, forme.color);
        } else {
            // Forme invalide
            return null;
        }
    }

}
