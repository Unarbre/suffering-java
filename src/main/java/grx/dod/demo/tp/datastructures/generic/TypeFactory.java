package grx.dod.demo.tp.datastructures.generic;

import java.util.Locale;

public class TypeFactory {

    public String get(String rawForm) {
        switch (rawForm.toUpperCase()) {
            case "R":
                return "Rectangle";
            case "C":
                return "Cercle";
            default:
                return "Error";
        }
    }
}
