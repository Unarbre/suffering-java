package grx.dod.demo.tp.datastructures.simplified.Manipulations;

import grx.dod.demo.tp.datastructures.contracts.EspaceCalculator;
import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;

import java.util.*;

public class SimplifiedEspaceCalculator implements EspaceCalculator<SimplifiedForme> {
    @Override
    public List<SimplifiedForme> output(List<SimplifiedForme> input) {
        List<Double> topX = new ArrayList<>();
        List<Double> topY = new ArrayList<>();
        List<Double> bottomX = new ArrayList<>();
        List<Double> bottomY = new ArrayList<>();


        HashSet<String> colors = new HashSet<>();

        for (SimplifiedForme forme : input) {
            if (!forme.type.equals("Cercle")) {
                Double x = forme.x;
                Double y = forme.y;
                Double width =  forme.width;
                Double height = forme.height;

                topX.add(x);
                topY.add(y);
                bottomX.add(x + width);
                bottomY.add(y + height);
                if (forme.type.equals("Rectangle")) colors.add(forme.color);
                if (forme.type.equals("Espace")) colors.addAll(forme.colors);
            }
        }



        if (!topX.isEmpty() && !topY.isEmpty()) {
            double minTopX = topX.stream().min(Double::compareTo).get();
            double minTopY = topY.stream().min(Double::compareTo).get();

            double maxBottomX = bottomX.stream().max(Comparator.naturalOrder()).get();
            double maxBottomY = bottomY.stream().max(Comparator.naturalOrder()).get();


            double width = Math.abs(maxBottomX - minTopX);
            double height = Math.abs(maxBottomY - minTopY);

            return Collections.singletonList(SimplifiedForme.createEspace(colors, minTopX, minTopY, width, height));
        } else {
            return Collections.emptyList();
        }
    }
}
