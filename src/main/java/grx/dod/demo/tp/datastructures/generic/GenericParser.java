package grx.dod.demo.tp.datastructures.generic;

import grx.dod.demo.tp.common.TypeFactory;
import grx.dod.demo.tp.contracts.FileParser;
import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
                        String[] parts = line.split(";");
                        String type = new TypeFactory().get(parts[0]);

                        HashMap<String, Object> map = new HashMap<>();
                        map.put("x", Math.abs(Integer.parseInt(parts[1])));
                        map.put("y", Math.abs(Integer.parseInt(parts[2])));

                        switch (type){
                            case "Cercle":
                                map.put("radius", parts[3]);
                                map.put("color", parts[4]);
                                break;
                            case "Rectangle":
                                map.put("width", parts[3]);
                                map.put("height", parts[4]);
                                map.put("color", parts[5]);
                            default:
                        }

                        return new Datatype(map, type);
                    }
            ).filter(Objects::nonNull).collect(Collectors.toList());
        }
    }
}
