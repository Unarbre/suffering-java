package grx.dod.demo.tp.typed.Manipulations;

import grx.dod.demo.tp.typed.Formes.Forme;

import java.util.List;

public interface Pipeline {
	
	List<Forme> output(List<Forme> input);

}
