package grx.dod.demo.tp.datastructures.typed.Formes;

public class Rectangle extends Forme {

	public double x;
	public double y;
	
	public double width;
	public double height;
	
	public Rectangle(double x, double y, double width, double height, String color) {
		super(RECTANGLE, color);
		this.x = x;
		this.y = y;
		this.width = Math.abs(width);
		this.height = Math.abs(height);
	}
	
	@Override
	public String toString() {
		return "R (x:"+x+", y:"+y+", w:"+width+", h:"+height+", c:"+color+")";
	}

}
