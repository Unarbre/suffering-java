package grx.dod.demo.tp.datastructures.generic;

import grx.dod.demo.tp.contracts.DataStructureScenario;
import grx.dod.demo.tp.datastructures.generic.Formes.Datatype;
import grx.dod.demo.tp.datastructures.generic.Manipulations.GenericConversion;
import grx.dod.demo.tp.datastructures.generic.Manipulations.GenericEspaceCalculator;
import grx.dod.demo.tp.datastructures.generic.Manipulations.GenericFilter;
import grx.dod.demo.tp.datastructures.typed.Formes.Espace;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Manipulations.TypedFilter;
import grx.dod.demo.tp.datastructures.typed.Manipulations.Mutation;

import java.util.ArrayList;
import java.util.List;

public class GenericScenario implements DataStructureScenario {

    List<Datatype> datatypes;
    private final GenericPrinter printer = new GenericPrinter();

    public GenericScenario(String filepath) throws Exception {
        this.datatypes = new GenericParser().parse(filepath);
    }

    public long startTimer() {
        return System.currentTimeMillis();
    }

    private void printTpTitle(int tpNumber) {
        System.out.println();
        System.out.println("Espace, TP générique N°" + tpNumber + ":");
    }

    private void printTimer(long start) {
        long end = System.currentTimeMillis();

        System.out.println(" => " + (end - start) + " (ms)");
    }

    @Override
    public void tp1() {
        printTpTitle(1);

        long start = startTimer();
        GenericEspaceCalculator espace = new GenericEspaceCalculator();
        List<Datatype> rects = new ArrayList<>();

        GenericConversion convertor = new GenericConversion();

        for (Datatype datatype: datatypes) {
            if (datatype.type.equals("Rectangle")) rects.add(datatype);
            if (datatype.type.equals("Cercle")) rects.add(convertor.apply(datatype));
        }

        this.printer.print(espace.output(rects));
        printTimer(start);
    }

    @Override
    public void tp2() {
        printTpTitle(2);

        long start = startTimer();

        GenericEspaceCalculator genericEspaceCalculator = new GenericEspaceCalculator();
        GenericConversion genericConversion = new GenericConversion();
        Mutation<Datatype> mutation = new Mutation<>(genericConversion);


        List<Datatype> s1 = genericEspaceCalculator.output(mutation.output(GenericFilter.output("Cercle", datatypes)));
        List<Datatype> s2 = genericEspaceCalculator.output((GenericFilter.output("Rectangle", datatypes)));


        System.out.println(s1);
        System.out.println(s2);

        List<Datatype> sN = new ArrayList<>();
        sN.addAll(s1);
        sN.addAll(s2);

        System.out.println(sN);

        this.printer.print(genericEspaceCalculator.output(sN));

        printTimer(start);
    }

    @Override
    public void tp3() throws Exception {
        printTpTitle(3);

        long start = startTimer();
    }

    @Override
    public void print() {
        this.printer.print(this.datatypes);
    }

    @Override
    public Espace calculEspace() {
        return null;
    }

    @Override
    public void draw() {

    }
}
