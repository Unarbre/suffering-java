package grx.dod.demo.tp.typed.Formes;

public class Cercle extends Forme {

	public double x;
	public double y;
	
	public double rayon;
	
	public Cercle(double x, double y, double rayon, String color) {
		super(CERCLE, color);
		this.x = x;
		this.y = y;
		this.rayon = rayon;
	}
	
	@Override
	public String toString() {
		return "C (x:"+x+", y:"+y+", r:"+rayon+", c:"+color+")";
	}

}
