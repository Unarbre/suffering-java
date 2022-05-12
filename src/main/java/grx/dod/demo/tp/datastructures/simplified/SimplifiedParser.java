package grx.dod.demo.tp.datastructures.simplified;

import grx.dod.demo.tp.datastructures.generic.TypeFactory;
import grx.dod.demo.tp.datastructures.contracts.FileParser;
import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SimplifiedParser implements FileParser<SimplifiedForme> {

    @Override
    public List<SimplifiedForme> parse(String filepath) throws Exception {
        File fichier = new File(filepath);
        try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
            return lecteur.lines().map(
                    line -> {
                        if (line == null) return null;
                        List<String> parts = Arrays.stream(line.split(";")).map(String::trim).collect(Collectors.toList());
                        String type = new TypeFactory().get(parts.get(0));
                        switch (type) {
                            case "Cercle":
                                return SimplifiedForme.createCercle(
                                        Double.parseDouble(parts.get(3)),
                                        parts.get(4),
                                        Double.parseDouble(parts.get(1)),
                                        Double.parseDouble(parts.get(2)));
                            case "Rectangle":
                                return SimplifiedForme.creacteRectangle(parts.get(5),
                                        Double.parseDouble(parts.get(1)),
                                        Double.parseDouble(parts.get(2)),
                                        Double.parseDouble(parts.get(3)),
                                        Double.parseDouble(parts.get(4)));
                            default:
                                return null;
                        }
                    }).filter(Objects::nonNull).collect(Collectors.toList());
        }
    }
}
