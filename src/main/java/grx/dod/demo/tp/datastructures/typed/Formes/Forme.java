package grx.dod.demo.tp.datastructures.typed.Formes;

public abstract class Forme {

	public String color;
	public String type;
	public static final String RECTANGLE = "R";
	public static final String CERCLE = "C";
	public static final String ESPACE = "E";

	protected Forme(String type, String color) {
		this.type = type;
		this.color = color;
	}

}
