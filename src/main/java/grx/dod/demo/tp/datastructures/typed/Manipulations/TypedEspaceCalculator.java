package grx.dod.demo.tp.datastructures.typed.Manipulations;

import grx.dod.demo.tp.datastructures.contracts.EspaceCalculator;
import grx.dod.demo.tp.datastructures.typed.Formes.Espace;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;

import java.util.*;

public class TypedEspaceCalculator implements EspaceCalculator<Forme> {

    // Retourne le rectangle représentant l'espace

    @Override
    public List<Forme> output(List<Forme> formes) {
        List<Double> topX = new ArrayList<>();
        List<Double> topY = new ArrayList<>();
        List<Double> bottomX = new ArrayList<>();
        List<Double> bottomY = new ArrayList<>();

        Rectangle rectangle;

        Set<String> colors = new HashSet<>();
        Espace espace;

        for (Forme forme : formes) {
            if (forme instanceof Rectangle) {
                rectangle = (Rectangle) forme;
                topX.add(rectangle.x);
                topY.add(rectangle.y);
                bottomX.add(rectangle.x + rectangle.width);
                bottomY.add(rectangle.y + rectangle.height);

                if (rectangle instanceof Espace) {
                    colors.addAll(((Espace) rectangle).colors);
                } else {
                    colors.add(forme.color);
                }
            }
        }

        if (!topX.isEmpty() && !topY.isEmpty()) {
            double minTopX = topX.stream().min(Double::compareTo).get();
            double minTopY = topY.stream().min(Double::compareTo).get();
            double maxBottomX = bottomX.stream().max(Comparator.naturalOrder()).get();
            double maxBottomY = bottomY.stream().max(Comparator.naturalOrder()).get();


            double width = Math.abs(maxBottomX - minTopX);
            double height = Math.abs(maxBottomY - minTopY);

            espace = new Espace(minTopX, minTopY, width, height, colors.toArray(new String[]{}));

            return Collections.singletonList(espace);
        } else {
            return Collections.emptyList();
        }
    }

}
