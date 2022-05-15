package grx.dod.demo.tp.datastructures.generic;

import grx.dod.demo.tp.Infrastructure.Tache;
import grx.dod.demo.tp.datastructures.contracts.DataStructureScenario;
import grx.dod.demo.tp.datastructures.contracts.Mutation;
import grx.dod.demo.tp.datastructures.generic.Formes.Datatype;
import grx.dod.demo.tp.datastructures.generic.Manipulations.*;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class GenericScenario implements DataStructureScenario<Datatype> {

    List<Datatype> datatypes;
    private final GenericPrinter printer = new GenericPrinter();
    private final GenericFormeConverter converter = new GenericFormeConverter();

    public GenericScenario() {}

    public long startTimer() {
        return System.currentTimeMillis();
    }

    private void printTpTitle(int tpNumber) {
        System.out.println();
        System.out.println("Espace, TP générique N°" + tpNumber + ":");
    }

    private long getTime(long start) {
        long end = System.currentTimeMillis();

        System.out.println(" => " + (end - start) + " (ms)");
        return end - start;
    }

    @Override
    public long tp1() {
        printTpTitle(1);

        long start = startTimer();
        GenericEspaceCalculator espace = new GenericEspaceCalculator();
        List<Datatype> rects = new ArrayList<>();

        GenericConversion convertor = new GenericConversion();

        for (Datatype datatype : datatypes) {
            if (datatype.type.equals("Rectangle")) rects.add(datatype);
            if (datatype.type.equals("Cercle")) rects.add(convertor.apply(datatype));
        }

        this.printer.print(espace.output(rects));

        return getTime(start);
    }

    @Override
    public long tp2() {
        printTpTitle(2);

        long start = startTimer();

        GenericEspaceCalculator genericEspaceCalculator = new GenericEspaceCalculator();
        GenericConversion genericConversion = new GenericConversion();
        Mutation<Datatype> mutation = new Mutation<>(genericConversion);


        List<Datatype> s1 = genericEspaceCalculator.output(mutation.output(GenericFilter.output("Cercle", datatypes)));
        List<Datatype> s2 = genericEspaceCalculator.output((GenericFilter.output("Rectangle", datatypes)));

        List<Datatype> sN = new ArrayList<>();
        sN.addAll(s1);
        sN.addAll(s2);

        this.printer.print(genericEspaceCalculator.output(sN));

        return getTime(start);
    }

    @Override
    public long tp3(int threadAmount) throws Exception {
        printTpTitle(3);

        long start = startTimer();

        GenericEspaceCalculator typedEspaceCalculator = new GenericEspaceCalculator();
        GenericConversion genericConversion = new GenericConversion();
        Tache<Datatype> mutation;

        ExecutorService processeur = Executors.newFixedThreadPool(threadAmount);

        List<Future<Datatype>> taches = new ArrayList<>();
        for (Datatype datatype : datatypes) {
            if (datatype.type.equals("Rectangle")) {
                mutation = new Tache<>(datatype);
            } else {
                mutation = new Tache<>(datatype, genericConversion);
            }
            taches.add(processeur.submit(mutation));
        }

        List<Datatype> espace = new ArrayList<>();
        for (Future<Datatype> tache : taches) {
            espace.add(tache.get());
        }

        processeur.shutdown();

        this.printer.print(typedEspaceCalculator.output(espace));
        return getTime(start);
    }

    @Override
    public void loadFormes(List<Forme> loadedFormes) {
        this.datatypes = loadedFormes.stream().map(converter::convert).collect(Collectors.toList());
    }

    @Override
    public void print() {
        this.printer.print(this.datatypes);
    }
}
