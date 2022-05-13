package grx.dod.demo.tp.datastructures.simplified.Manipulations;

import grx.dod.demo.tp.datastructures.contracts.FormeConverter;
import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;
import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;

public class SimplifiedFormeConverter implements FormeConverter<SimplifiedForme> {
    @Override
    public SimplifiedForme convert(Forme toConvert) {
        if (toConvert.type.equals(Forme.RECTANGLE)) {
            Rectangle r = (Rectangle) toConvert;
            return SimplifiedForme.creacteRectangle(r.color, r.x, r.y, r.width, r.height);
        }

        if (toConvert.type.equals(Forme.CERCLE)) {
            Cercle c = (Cercle) toConvert;
            return SimplifiedForme.createCercle(c.rayon, c.color, c.x, c.y);
        }

        return null;
    }
}
