package grx.dod.demo.tp.contracts;

import grx.dod.demo.tp.datastructures.typed.Manipulations.Pipeline;

import java.util.List;

public interface EspaceCalculator<T> extends Pipeline<T> {


    List<T> output(List<T> input);
}
