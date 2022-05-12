package grx.dod.demo.tp.datastructures.contracts;

import java.util.List;

public interface EspaceCalculator<T> extends Pipeline<T> {


    List<T> output(List<T> input);
}
