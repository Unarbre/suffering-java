package grx.dod.demo.tp.typed;

import grx.dod.demo.tp.contracts.FileParser;
import grx.dod.demo.tp.typed.Formes.Cercle;
import grx.dod.demo.tp.typed.Formes.Forme;
import grx.dod.demo.tp.typed.Formes.Rectangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class TypedParser implements FileParser<Forme> {


    public List<Forme> parse(String filePath) throws Exception {
        File fichier = new File(filePath);

        try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
            return lecteur.lines().map(
                    line -> {
                        Forme forme;

                        if (line != null) {
                            String[] parts = line.split(";");
                            String type = parts[0];

                            if (Forme.CERCLE.equals(type)) {
                                forme = new Cercle(
                                        Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
                                        Double.parseDouble(parts[3]),
                                        parts[4]
                                );
                            } else if (Forme.RECTANGLE.equals(type)) {
                                forme = new Rectangle(
                                        Double.parseDouble(parts[1]), Double.parseDouble(parts[2]),
                                        Double.parseDouble(parts[3]), Double.parseDouble(parts[4]),
                                        parts[5]
                                );
                            } else {
                                // Inconnu
                                forme = null;
                            }
                        } else {
                            // Inconnu
                            forme = null;
                        }

                        return forme;
                    }
            ).collect(Collectors.toList());
        }

    }
}
