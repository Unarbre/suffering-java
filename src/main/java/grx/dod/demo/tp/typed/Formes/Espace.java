package grx.dod.demo.tp.typed.Formes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Espace extends Rectangle {

	public Set<String> colors;
	
	public Espace(double x, double y, double width, double height, String ... colors) {
		super(x, y, width, height, colors[0]);
		
		this.colors = new HashSet<>();
		this.colors.addAll(Arrays.asList(colors));
	}
	
	@Override
	public String toString() {
		return "E (x:"+x+", y:"+y+", w:"+width+", h:"+height+", c:"+colors+")";
	}

}
