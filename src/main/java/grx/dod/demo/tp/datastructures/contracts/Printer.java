package grx.dod.demo.tp.datastructures.contracts;

import java.util.List;

public interface Printer<Printed> {

    void print(List<Printed> forms);
}
