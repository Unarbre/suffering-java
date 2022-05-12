package grx.dod.demo.tp.datastructures.simplified.Manipulations;

import grx.dod.demo.tp.datastructures.contracts.Pipeline;
import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;

import java.util.List;
import java.util.stream.Collectors;

public class SimplifiedFilter implements Pipeline<SimplifiedForme> {


    String type;

    public SimplifiedFilter(String type) {
        this.type = type;
    }

    @Override
    public List<SimplifiedForme> output(List<SimplifiedForme> input) {
        return input.stream()
                .filter(
                        datatype ->
                                (datatype != null && type.equals(datatype.type))
                ).collect(Collectors.toList());
    }

    public static List<SimplifiedForme> output(String type, List<SimplifiedForme> input) {
        return (new SimplifiedFilter(type)).output(input);
    }
}
