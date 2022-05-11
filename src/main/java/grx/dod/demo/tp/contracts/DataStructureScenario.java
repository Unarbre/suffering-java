package grx.dod.demo.tp.contracts;

import grx.dod.demo.tp.datastructures.typed.Formes.Espace;

public interface DataStructureScenario<T> {

    void tp1();
    void tp2();
    void tp3() throws Exception;

    void print();

    T calculEspace();
    void draw();
}
