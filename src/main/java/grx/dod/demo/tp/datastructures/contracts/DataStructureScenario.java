package grx.dod.demo.tp.datastructures.contracts;

import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

import java.util.List;

public interface DataStructureScenario<T> {

    void tp1();
    void tp2();
    void tp3() throws Exception;

    void loadFormes(List<Forme> loadedFormes);

    void print();
}
