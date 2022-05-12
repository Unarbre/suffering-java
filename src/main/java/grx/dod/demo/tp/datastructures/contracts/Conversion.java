package grx.dod.demo.tp.datastructures.contracts;

import java.util.function.Function;

public interface Conversion<T> extends Function<T, T> {

    @Override
    T apply(T t);
}
