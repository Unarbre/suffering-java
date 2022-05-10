package grx.dod.demo.tp.Infrastructure;

import grx.dod.demo.tp.typed.Formes.Forme;
import grx.dod.demo.tp.typed.Manipulations.Conversion;

import java.util.concurrent.Callable;

public class Tache implements Callable<Forme> {

    Forme forme;
    Conversion conversion;

    public Tache(Forme forme) {
        this.forme = forme;
    }

    public Tache(Forme forme, Conversion conversion) {
        this.forme = forme;
        this.conversion = conversion;
    }

    @Override
    public Forme call() {
        if (conversion != null) {
            // On applique la conversion
            return conversion.apply(forme);
        } else {
            // Sa conversion
            return forme;
        }
    }

}
