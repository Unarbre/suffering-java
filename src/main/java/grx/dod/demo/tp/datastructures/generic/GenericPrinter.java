package grx.dod.demo.tp.datastructures.generic;

import grx.dod.demo.tp.contracts.Printer;

import java.util.List;

public class GenericPrinter implements Printer<Datatype> {
    @Override
    public void print(List<Datatype> datatypes) {
        System.out.println();
        System.out.println("Datatype :");
        for (Datatype datatype : datatypes) {
            System.out.println(" > " + datatype);
        }
        System.out.println(" => " + datatypes.size() + " (datatypes)");
    }
}
