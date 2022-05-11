package grx.dod.demo.tp.datastructures.generic.Manipulations;

import grx.dod.demo.tp.datastructures.generic.Formes.Datatype;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Manipulations.Pipeline;

import java.util.List;
import java.util.stream.Collectors;

public class GenericFilter implements Pipeline<Datatype> {
    String type;

    public GenericFilter(String type) {
        this.type = type;
    }

    @Override
    public List<Datatype> output(List<Datatype> input) {
        return input.stream()
                .filter(
                        datatype ->
                                (datatype != null && type.equals(datatype.type))

                ).collect(Collectors.toList());
    }

    public static List<Datatype> output(String type, List<Datatype> input) {
        return (new GenericFilter(type)).output(input);
    }
}
