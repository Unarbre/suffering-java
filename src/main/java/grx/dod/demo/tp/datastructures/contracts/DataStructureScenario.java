package grx.dod.demo.tp.datastructures.contracts;

public interface DataStructureScenario<T> {

    void tp1();
    void tp2();
    void tp3() throws Exception;

    void print();

    T calculEspace();
}
