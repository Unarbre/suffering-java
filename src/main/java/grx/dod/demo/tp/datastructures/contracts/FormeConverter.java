package grx.dod.demo.tp.datastructures.contracts;

import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

public interface FormeConverter<T> {
    T convert(Forme toConvert);
}
