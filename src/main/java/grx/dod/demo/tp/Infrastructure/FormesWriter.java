package grx.dod.demo.tp.Infrastructure;

import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FormesWriter {
    String separator = ";";
    String endOfLine = System.lineSeparator();

    public void writeTo(String filepath, List<Forme> formes) throws IOException {
        FileWriter myWriter = new FileWriter(filepath);
        for (Forme forme : formes) {
            myWriter.write(getFormeString(forme));
        }
        myWriter.close();
    }

    private String getFormeString(Forme forme) {
        if (forme.type.equals(Forme.CERCLE)) {
            Cercle c = (Cercle) forme;
            return c.type + separator + c.x + separator + c.y + separator + c.rayon + separator + c.color + endOfLine;
        }


        if (forme.type.equals(Forme.RECTANGLE)) {
            Rectangle c = (Rectangle) forme;
            return c.type + separator + c.x + separator + c.y + separator + c.width + separator + c.height + separator + c.color + endOfLine;
        }


        return "";
    }
}
