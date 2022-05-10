package grx.dod.demo.tp.datastructures.generic;

import grx.dod.demo.tp.contracts.DataStructureScenario;
import grx.dod.demo.tp.datastructures.typed.Formes.Espace;

import java.util.List;

public class GenericScenario implements DataStructureScenario {

    List<Datatype> datatypes;
    private final GenericPrinter printer = new GenericPrinter();

    public GenericScenario(String filepath) throws Exception {
        this.datatypes = new GenericParser().parse(filepath);
    }

    @Override
    public void tp1() {

    }

    @Override
    public void tp2() {

    }

    @Override
    public void tp3() throws Exception {

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
