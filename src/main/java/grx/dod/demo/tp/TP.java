package grx.dod.demo.tp;

import grx.dod.demo.tp.ihm.MainPanel;

import javax.swing.*;

public class TP {

	
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Calcul d'espace");
		frame.setContentPane(new MainPanel().panel1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
