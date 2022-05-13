package grx.dod.demo.tp.datastructures.generic.Manipulations;

import grx.dod.demo.tp.datastructures.contracts.FormeConverter;
import grx.dod.demo.tp.datastructures.generic.Formes.Datatype;
import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;

import java.util.HashMap;

public class GenericFormeConverter implements FormeConverter<Datatype> {
    @Override
    public Datatype convert(Forme toConvert) {
        HashMap<String, Object> map = new HashMap<>();
        if (toConvert.type.equals(Forme.RECTANGLE)) {
            Rectangle r = (Rectangle) toConvert;
            map.put("x", r.x);
            map.put("y", r.y);
            map.put("width", r.width);
            map.put("height", r.height);
        }

        if (toConvert.type.equals(Forme.CERCLE)) {
            Cercle c = (Cercle) toConvert;
            map.put("x", c.x);
            map.put("y", c.y);
            map.put("radius", c.rayon);

        }

        return new Datatype(map, toConvert.type);
    }
}
