package grx.dod.demo.tp.datastructures.contracts;

import java.util.List;

public interface Pipeline<T> {
	
	List<T> output(List<T> input);

}
