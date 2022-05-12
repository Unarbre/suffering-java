package grx.dod.demo.tp.datastructures.simplified.Manipulations;

import grx.dod.demo.tp.datastructures.contracts.Conversion;
import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;

public class SimplifiedConversion implements Conversion<SimplifiedForme> {
    @Override
    public SimplifiedForme apply(SimplifiedForme simplifiedForme) {
        if (simplifiedForme.type.equals("Cercle")) {
            return SimplifiedForme.creacteRectangle(
                    simplifiedForme.color,
                    simplifiedForme.x - simplifiedForme.radius,
                    simplifiedForme.y - simplifiedForme.radius,
                    simplifiedForme.radius * 2,
                    simplifiedForme.radius * 2
            );
        }

        return simplifiedForme;
    }
}
