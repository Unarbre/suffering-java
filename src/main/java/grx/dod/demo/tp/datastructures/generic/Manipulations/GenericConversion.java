package grx.dod.demo.tp.datastructures.generic.Manipulations;

import grx.dod.demo.tp.contracts.Conversion;
import grx.dod.demo.tp.datastructures.generic.Formes.Datatype;

import java.util.HashMap;

public class GenericConversion implements Conversion<Datatype> {
    @Override
    public Datatype apply(Datatype datatype) {
        if (datatype.type.equals("Cercle")) {
            Integer rayon =  datatype.getInteger("radius");
            HashMap<String, Object> rectangle = new HashMap<>();
            rectangle.put("x", datatype.getInteger("x") - rayon);
            rectangle.put("y", datatype.getInteger("y") - rayon);
            rectangle.put("width", rayon * 2);
            rectangle.put("height", rayon * 2);
            rectangle.put("color", datatype.getString("color"));

            return new Datatype(rectangle, "Rectangle");
        }

        return datatype;
    }
}
