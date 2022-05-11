package grx.dod.demo.tp.datastructures.generic.Manipulations;

import grx.dod.demo.tp.contracts.EspaceCalculator;
import grx.dod.demo.tp.datastructures.generic.Formes.Datatype;

import java.util.*;

public class GenericEspaceCalculator implements EspaceCalculator<Datatype> {
    @Override
    public List<Datatype> output(List<Datatype> datatypes) {
        List<Double> topX = new ArrayList<>();
        List<Double> topY = new ArrayList<>();
        List<Double> bottomX = new ArrayList<>();
        List<Double> bottomY = new ArrayList<>();


        Set<String> colors = new HashSet<>();

        for (Datatype datatype : datatypes) {
            if (!datatype.type.equals("Cercle")) {
                Double x = datatype.getDouble("x");
                Double y = datatype.getDouble("y");
                Double width =  datatype.getDouble("width");
                Double height = datatype.getDouble("height");

                topX.add(x);
                topY.add(y);
                bottomX.add(x + width);
                bottomY.add(y + height);
                if (datatype.type.equals("Rectangle")) colors.add(datatype.getString("color"));
                if (datatype.type.equals("Espace")) colors.addAll(datatype.getStringHashSet("colors"));
            }
        }



        if (!topX.isEmpty() && !topY.isEmpty()) {
            double minTopX = topX.stream().min(Double::compareTo).get();
            double minTopY = topY.stream().min(Double::compareTo).get();

            double maxBottomX = bottomX.stream().max(Comparator.naturalOrder()).get();
            double maxBottomY = bottomY.stream().max(Comparator.naturalOrder()).get();


            double width = Math.abs(maxBottomX - minTopX);
            double height = Math.abs(maxBottomY - minTopY);

            HashMap<String, Object> map = new HashMap<String, Object>() {{
                put("x", minTopX);
                put("y", minTopY);
                put("width", width);
                put("height", height);
                put("colors", colors);
            }};

            return Collections.singletonList(new Datatype(map, "Espace"));
        } else {
            return Collections.emptyList();
        }
    }
}
