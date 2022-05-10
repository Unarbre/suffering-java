package grx.dod.demo.tp;

import grx.dod.demo.tp.datastructures.generic.GenericScenario;

public class TP {

	
	public static void main(String[] args) throws Exception {
		GenericScenario scenario = new GenericScenario("src/main/resources/espace.txt");

		scenario.print();

		scenario.tp1();

		scenario.tp2();

		scenario.tp3();

		scenario.draw();
	}

}
