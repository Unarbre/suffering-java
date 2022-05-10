package grx.dod.demo.tp;

import java.util.HashSet;
import java.util.Set;

public class Espace extends Rectangle {

	Set<String> colors;
	
	public Espace(double x, double y, double width, double height, String ... colors) {
		super(x, y, width, height, colors[0]);
		
		this.colors = new HashSet<>();
		for (String color : colors) {
			this.colors.add(color);
		}
	}
	
	@Override
	public String toString() {
		return "E (x:"+x+", y:"+y+", w:"+width+", h:"+height+", c:"+colors+")";
	}

}
