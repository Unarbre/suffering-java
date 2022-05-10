package grx.dod.demo.tp.typed.Manipulations;

import grx.dod.demo.tp.contracts.Printer;
import grx.dod.demo.tp.typed.Formes.Forme;

import java.util.List;

public class TypedPrinter implements Printer<Forme> {

    public void print(List<Forme> formes) {
        System.out.println();
        System.out.println("Formes :");
        for (Forme forme : formes) {
            System.out.println(" > " + forme);
        }
        System.out.println(" => "+formes.size()+" (formes)");
    }

}
