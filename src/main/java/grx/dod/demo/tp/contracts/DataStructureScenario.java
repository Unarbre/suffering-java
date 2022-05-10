package grx.dod.demo.tp.contracts;

import grx.dod.demo.tp.typed.Formes.Espace;

import java.util.List;

public interface DataStructureScenario<Structure> {
    void tp1();
    void tp2();
    void tp3() throws Exception;

    Espace calculEspace();
    void draw();
}
