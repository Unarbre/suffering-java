package grx.dod.demo.tp;

import grx.dod.demo.tp.typed.Formes.Cercle;
import grx.dod.demo.tp.typed.Formes.Espace;
import grx.dod.demo.tp.typed.Formes.Forme;
import grx.dod.demo.tp.typed.Formes.Rectangle;
import grx.dod.demo.tp.typed.Manipulations.*;
import grx.dod.demo.tp.typed.TypedScenario;

import java.util.ArrayList;
import java.util.List;

public class TP {

	
	public static void main(String[] args) throws Exception {
		TypedScenario typedScenario = new TypedScenario("src/main/resources/espace.txt");

		typedScenario.tp1();

		typedScenario.tp2();

		typedScenario.tp3();

		typedScenario.draw();
	}

}
