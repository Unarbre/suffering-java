package grx.dod.demo.tp.datastructures.typed.Manipulations;

import grx.dod.demo.tp.contracts.Conversion;

import java.util.List;
import java.util.stream.Collectors;

public class Mutation<T> implements Pipeline<T> {

    Conversion<T> conversion;

    public Mutation(Conversion<T> conversion) {
        this.conversion = conversion;
    }

    @Override
    public List<T> output(List<T> input) {
        if (conversion != null) {
            return input.stream().map(conversion)
                    .collect(Collectors.toList());
        } else {
            return input;
        }
    }

}
