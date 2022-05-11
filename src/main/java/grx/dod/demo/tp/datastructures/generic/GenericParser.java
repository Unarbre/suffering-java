package grx.dod.demo.tp.datastructures.generic;

import grx.dod.demo.tp.common.TypeFactory;
import grx.dod.demo.tp.contracts.FileParser;
import grx.dod.demo.tp.datastructures.generic.Formes.Datatype;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GenericParser implements FileParser<Datatype> {
    @Override
    public List<Datatype> parse(String filepath) throws Exception {
        File fichier = new File(filepath);
        try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
            return lecteur.lines().map(
                    line -> {
                        if (line == null) return null;
                        List<String> parts = Arrays.stream(line.split(";")).map(String::trim).collect(Collectors.toList());
                        String type = new TypeFactory().get(parts.get(0));

                        HashMap<String, Object> map = new HashMap<>();
                        map.put("x", parts.get(1));
                        map.put("y", parts.get(2));

                        switch (type){
                            case "Cercle":
                                map.put("radius", parts.get(3));
                                map.put("color", parts.get(4));
                                break;
                            case "Rectangle":
                                map.put("width", Integer.parseInt(parts.get(3)));
                                map.put("height", Integer.parseInt(parts.get(4)));
                                map.put("color", parts.get(5));
                            default:
                        }

                        return new Datatype(map, type);
                    }
            ).filter(Objects::nonNull).collect(Collectors.toList());
        }
    }
}
