package grx.dod.demo.tp;

import java.util.*;

public class Emission implements Pipeline {

	// Retourne le rectangle représentant l'espace
	
	@Override
	public List<Forme> output(List<Forme> formes) {
		List<Double> topX = new ArrayList<>();
		List<Double> topY = new ArrayList<>();
		List<Double> bottomX = new ArrayList<>();
		List<Double> bottomY = new ArrayList<>();
		
		double minTopX;
		double minTopY;
		double maxBottomX;
		double maxBottomY;
		Rectangle rectangle;
		
		double x;
		double y;
		double width;
		double height;
		Set<String> colors = new HashSet<>();
		Espace espace;
		
		for (Forme forme : formes) {
			if (forme instanceof Rectangle) {
				rectangle = (Rectangle)forme;
				topX.add(rectangle.x);
				topY.add(rectangle.y);
				bottomX.add(rectangle.x + rectangle.width);
				bottomY.add(rectangle.y + rectangle.height);
				
				if (rectangle instanceof Espace) {
					colors.addAll(((Espace)rectangle).colors);
				} else {
					colors.add(forme.color);
				}
			}
		}
		
		if (!topX.isEmpty() && !topY.isEmpty()) {
			minTopX = topX.stream().min(Double::compareTo).get();
			minTopY = topY.stream().min(Double::compareTo).get();
			maxBottomX = bottomX.stream().max(Comparator.naturalOrder()).get();
			maxBottomY = bottomY.stream().max(Comparator.naturalOrder()).get();
			
			x = minTopX;
			y = minTopY;
			width = Math.abs(maxBottomX - minTopX);
			height = Math.abs(maxBottomY - minTopY);
			
			espace = new Espace(x, y, width, height, colors.toArray(new String[]{}));
			
			return Collections.singletonList(espace);
		} else {
			return Collections.emptyList();
		}
	}

}
