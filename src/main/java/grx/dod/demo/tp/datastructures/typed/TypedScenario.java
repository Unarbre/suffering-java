package grx.dod.demo.tp.datastructures.typed;

import grx.dod.demo.tp.Infrastructure.Tache;
import grx.dod.demo.tp.contracts.DataStructureScenario;
import grx.dod.demo.tp.datastructures.typed.Formes.Cercle;
import grx.dod.demo.tp.datastructures.typed.Formes.Espace;
import grx.dod.demo.tp.datastructures.typed.Formes.Forme;
import grx.dod.demo.tp.datastructures.typed.Formes.Rectangle;
import grx.dod.demo.tp.datastructures.typed.Graphical.TypedDraw;
import grx.dod.demo.tp.datastructures.typed.Manipulations.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TypedScenario implements DataStructureScenario {

    List<Forme> formes;
    private final TypedPrinter printer = new TypedPrinter();

    public TypedScenario(String filePath) throws Exception {
        TypedParser parser = new TypedParser();
        this.formes = parser.parse(filePath);
    }

    public long startTimer() {
        return System.currentTimeMillis();
    }

    public static void printTimer(long start) {
        long end = System.currentTimeMillis();

        System.out.println(" => " + (end - start) + " (ms)");
    }

    @Override
    public void print() {
        this.printer.print(this.formes);
    }


    void printTpTitle(int tpNumber) {
        System.out.println();
        System.out.println("Espace, TP N°" + tpNumber + ":");
    }


    @Override
    public void tp1() {
        printTpTitle(1);

        long start = startTimer();
        Emission espace = new Emission();
        List<Forme> rects = new ArrayList<>();
        TypedConversion typedConversion = new TypedConversion();

        for (Forme forme : formes) {
            if (forme instanceof Rectangle) {
                // Rien à faire
                rects.add(forme);
            } else if (forme instanceof Cercle) {
                // Conversion à faire
                rects.add(typedConversion.apply(forme));
            }
        }

        TypedPrinter affichage = new TypedPrinter();
        affichage.print(espace.output(rects));
        printTimer(start);
    }

    @Override
    public void tp2() {
        printTpTitle(2);

        long start = startTimer();

        Emission emission = new Emission();
        TypedConversion typedConversion = new TypedConversion();
        Mutation mutation = new Mutation(typedConversion);

        List<Forme> s1;
        List<Forme> s2;

        s1 = emission.output(mutation.output(Filtre.output(Forme.CERCLE, formes)));
        s2 = emission.output((Filtre.output(Forme.RECTANGLE, formes)));

        List<Forme> sN = new ArrayList<>();
        sN.addAll(s1);
        sN.addAll(s2);

        TypedPrinter affichage = new TypedPrinter();
        affichage.print(emission.output(sN));

        printTimer(start);
    }

    @Override
    public void tp3() throws Exception {

        printTpTitle(3);

        long start = startTimer();

        Emission emission = new Emission();
        TypedConversion typedConversion = new TypedConversion();
        Tache<Forme> mutation;

        int nbCoeurs = 2;
        ExecutorService processeur = Executors.newFixedThreadPool(nbCoeurs);

        List<Future<Forme>> taches = new ArrayList<>();
        for (Forme forme : formes) {
            if (forme instanceof Rectangle) {
                // Pas de conversion
                mutation = new Tache<>(forme);
            } else {
                // Avec conversion
                mutation = new Tache<>(forme, typedConversion);
            }
            taches.add(processeur.submit(mutation));
        }

        List<Forme> espace = new ArrayList<>();
        for (Future<Forme> tache : taches) {
            espace.add(tache.get());
        }

        processeur.shutdown();

        TypedPrinter affichage = new TypedPrinter();
        affichage.print(emission.output(espace));
        printTimer(start);
    }

    @Override
    public Espace calculEspace() {
        List<Forme> rects = new ArrayList<>();
        TypedConversion typedConversion = new TypedConversion();

        for (Forme forme : formes) {
            if (forme instanceof Rectangle) {
                // Rien à faire
                rects.add(forme);
            } else if (forme instanceof Cercle) {
                // Conversion à faire
                rects.add(typedConversion.apply(forme));
            }
        }

        Emission espace = new Emission();

        return (Espace) espace.output(rects).get(0);
    }


    @Override
    public void draw() {
        JFrame window = new JFrame("Espace d'occupation des formes");
        window.setLayout(new BorderLayout());
        window.add(new TypedDraw(formes, this.calculEspace()), BorderLayout.CENTER);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


}
