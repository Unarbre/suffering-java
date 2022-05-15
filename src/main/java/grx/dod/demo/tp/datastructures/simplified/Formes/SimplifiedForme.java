package grx.dod.demo.tp.datastructures.simplified.Formes;

import java.util.HashSet;

public class SimplifiedForme {

    public String type;
    public double radius;
    public double x;
    public double y;
    public double height;
    public double width;
    public HashSet<String> colors;
    public String color;


    private SimplifiedForme(String type, double radius, String color, double x, double y) {
        this.type = type;
        this.radius = radius;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public static SimplifiedForme createCercle(double radius, String color, double x, double y) {
        return new SimplifiedForme("Cercle", radius, color, x, y);
    }

    private SimplifiedForme(String type, String color, double x, double y, double width, double height) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static SimplifiedForme creacteRectangle(String color, double x, double y, double width, double height) {
        return new SimplifiedForme("Rectangle", color, x, y, width, height);
    }

    private SimplifiedForme(String type, HashSet<String> colors, double x, double y, double width, double height) {
        this.type = type;
        this.colors = colors;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public static SimplifiedForme createEspace(HashSet<String> colors, double x, double y, double width, double height) {
        return new SimplifiedForme("Espace", colors, x, y, width, height);
    }


    @Override
    public String toString() {
        return "SimplifiedForme{" +
                "type='" + type + '\'' +
                ", radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                ", height=" + height +
                ", width=" + width +
                ", colors=" + colors +
                ", color='" + color + '\'' +
                '}';
    }
}
