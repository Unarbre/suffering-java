package grx.dod.demo.tp;

import grx.dod.demo.tp.datastructures.generic.GenericScenario;
import grx.dod.demo.tp.datastructures.typed.TypedScenario;

public class TP {

	
	public static void main(String[] args) throws Exception {
		GenericScenario scenario = new GenericScenario("src/main/resources/espace.txt");

		scenario.tp1();

		scenario.tp2();

		scenario.tp3();

//		GenericScenario scenario2 = new GenericScenario("src/main/resources/espace.txt");
//
//		scenario2.tp1();
//
//		scenario2.tp2();
//
//		scenario.tp3();

		scenario.draw();
	}

}
