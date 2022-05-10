package grx.dod.demo.tp.datastructures.typed.Manipulations;

import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

import java.util.List;
import java.util.stream.Collectors;

public class Filtre implements Pipeline {

    String type;

    public Filtre(String type) {
        this.type = type;
    }

    @Override
    public List<Forme> output(List<Forme> input) {
        return input.stream()
                .filter(
                        forme ->
                                (forme != null && type.equals(forme.type))

		).collect(Collectors.toList());
    }

    public static List<Forme> output(String type, List<Forme> input) {
        return (new Filtre(type)).output(input);
    }

}
