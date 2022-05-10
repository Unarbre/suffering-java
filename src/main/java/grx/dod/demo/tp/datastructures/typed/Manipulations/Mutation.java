package grx.dod.demo.tp.datastructures.typed.Manipulations;

import grx.dod.demo.tp.datastructures.typed.Formes.Forme;

import java.util.List;
import java.util.stream.Collectors;

public class Mutation implements Pipeline {

	// Transforme : Cercle => Rectangle
	
	TypedConversion typedConversion;
	
	public Mutation(TypedConversion typedConversion) {
		this.typedConversion = typedConversion;
	}
	
	@Override
	public List<Forme> output(List<Forme> input) {
		if (typedConversion !=null) {
			return input.stream().map(typedConversion)
			.collect(Collectors.toList());
		} else {
			return input;
		}
	}

}
