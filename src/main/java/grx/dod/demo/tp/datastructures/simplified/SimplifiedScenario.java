package grx.dod.demo.tp.datastructures.simplified;

import grx.dod.demo.tp.Infrastructure.Tache;
import grx.dod.demo.tp.datastructures.contracts.DataStructureScenario;
import grx.dod.demo.tp.datastructures.contracts.Mutation;
import grx.dod.demo.tp.datastructures.simplified.Formes.SimplifiedForme;
import grx.dod.demo.tp.datastructures.simplified.Manipulations.*;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SimplifiedScenario implements DataStructureScenario<SimplifiedForme> {

    List<SimplifiedForme> formes;
    private final SimplifiedPrinter printer = new SimplifiedPrinter();

    private final SimplifiedFormeConverter converter = new SimplifiedFormeConverter();

    public long startTimer() {
        return System.currentTimeMillis();
    }

    private void printTpTitle(int tpNumber) {
        System.out.println();
        System.out.println("Espace, TP simplifié N°" + tpNumber + ":");
    }

    private void printTimer(long start) {
        long end = System.currentTimeMillis();

        System.out.println(" => " + (end - start) + " (ms)");
    }



    @Override
    public void tp1() {
        printTpTitle(1);

        long start = startTimer();
        SimplifiedEspaceCalculator espace = new SimplifiedEspaceCalculator();
        List<SimplifiedForme> rects = new ArrayList<>();

        SimplifiedConversion convertor = new SimplifiedConversion();

        for (SimplifiedForme forme: formes) {
            if (forme.type.equals("Rectangle")) rects.add(forme);
            if (forme.type.equals("Cercle")) rects.add(convertor.apply(forme));
        }

        this.printer.print(espace.output(rects));
        printTimer(start);
    }

    @Override
    public void tp2() {
        printTpTitle(2);

        long start = startTimer();

        SimplifiedEspaceCalculator simplifiedEspaceCalculator = new SimplifiedEspaceCalculator();
        SimplifiedConversion simplifiedConversion = new SimplifiedConversion();
        Mutation<SimplifiedForme> mutation = new Mutation<>(simplifiedConversion);


        List<SimplifiedForme> s1 = simplifiedEspaceCalculator.output(mutation.output(SimplifiedFilter.output("Cercle", formes)));
        List<SimplifiedForme> s2 = simplifiedEspaceCalculator.output((SimplifiedFilter.output("Rectangle", formes)));

        List<SimplifiedForme> sN = new ArrayList<>();
        sN.addAll(s1);
        sN.addAll(s2);

        this.printer.print(simplifiedEspaceCalculator.output(sN));

        printTimer(start);
    }

    @Override
    public void tp3() throws Exception {
        printTpTitle(3);

        long start = startTimer();

        SimplifiedEspaceCalculator simplifiedEspaceCalculator = new SimplifiedEspaceCalculator();
        SimplifiedConversion simplifiedConversion = new SimplifiedConversion();
        Tache<SimplifiedForme> mutation;

        int nbCoeurs = 2;
        ExecutorService processeur = Executors.newFixedThreadPool(nbCoeurs);

        List<Future<SimplifiedForme>> taches = new ArrayList<>();
        for (SimplifiedForme forme : formes) {
            if (forme.type.equals("Rectangle")) {
                mutation = new Tache<>(forme);
            } else {
                mutation = new Tache<>(forme, simplifiedConversion);
            }
            taches.add(processeur.submit(mutation));
        }

        List<SimplifiedForme> espace = new ArrayList<>();
        for (Future<SimplifiedForme> tache : taches) {
            espace.add(tache.get());
        }

        processeur.shutdown();

        this.printer.print(simplifiedEspaceCalculator.output(espace));
        printTimer(start);
    }

    @Override
    public void print() {
        this.printer.print(this.formes);
    }


    @Override
    public void loadFormes(List<Forme> loadedFormes) {
        this.formes = loadedFormes.stream().map(this.converter::convert).collect(Collectors.toList());
    }
}
