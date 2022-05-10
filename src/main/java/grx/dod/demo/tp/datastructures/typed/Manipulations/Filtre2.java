package grx.dod.demo.tp.datastructures.typed.Manipulations;

import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

import java.util.List;
import java.util.stream.Collectors;

public class Filtre2 implements Pipeline {

	Class<? extends Forme> type;
	
	public Filtre2(Class<? extends Forme> type) {
		this.type = type;
	}
	
	@Override
	public List<Forme> output(List<Forme> input) {
		return input.stream()
		.filter(
			forme ->
				 type.isInstance(forme)

		).collect(Collectors.toList());
	}
	
	public static List<Forme> output(Class<? extends Forme> type, List<Forme> input) {
		return (new Filtre2(type)).output(input);
	}

}
