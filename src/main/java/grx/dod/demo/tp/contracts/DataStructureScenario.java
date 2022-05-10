package grx.dod.demo.tp.contracts;

import grx.dod.demo.tp.datastructures.typed.Formes.Espace;

public interface DataStructureScenario {

    void tp1();
    void tp2();
    void tp3() throws Exception;

    void print();

    Espace calculEspace();
    void draw();
}
