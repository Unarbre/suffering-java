package grx.dod.demo.tp.datastructures.simplified.Manipulations;

import grx.dod.demo.tp.datastructures.contracts.Printer;
import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;

import java.util.List;

public class SimplifiedPrinter implements Printer<SimplifiedForme> {
    @Override
    public void print(List<SimplifiedForme> forms) {
        System.out.println();
        System.out.println("Simplified types :");
        for (SimplifiedForme forme : forms) {
            System.out.println(" > " + forme);
        }
        System.out.println(" => " + forms.size() + " (datatypes)");
    }
}
