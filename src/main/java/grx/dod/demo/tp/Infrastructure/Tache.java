package grx.dod.demo.tp.Infrastructure;

import grx.dod.demo.tp.datastructures.contracts.Conversion;

import java.util.concurrent.Callable;

public class Tache<T> implements Callable<T> {

    T forme;
    Conversion<T> conversion;

    public Tache(T forme) {
        this.forme = forme;
    }

    public Tache(T forme, Conversion<T> conversion) {
        this.forme = forme;
        this.conversion = conversion;
    }

    @Override
    public T call() {
        if (conversion != null) {
            // On applique la conversion
            return conversion.apply(forme);
        } else {
            // Sa conversion
            return forme;
        }
    }

}
