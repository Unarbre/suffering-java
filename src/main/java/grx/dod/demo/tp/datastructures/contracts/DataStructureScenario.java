package grx.dod.demo.tp.datastructures.contracts;

import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

import java.util.List;

public interface DataStructureScenario<T> {

    long tp1();
    long tp2();
    long tp3(int threadAmount) throws Exception;

    void loadFormes(List<Forme> loadedFormes);

    void print();
}
