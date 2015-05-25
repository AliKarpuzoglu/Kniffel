package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Spieler;
import logic.Wurf;

public class SwingClass {
	public void printReihenfolge(Spieler[] spieler) {

		JFrame spielerNamen = new JFrame("Spieler");

		spielerNamen.setSize(400, 200);

		for (int i = 0; i < spieler.length; i++) {
			spielerNamen.add(new JLabel(" " + spieler[i]));
		}

		spielerNamen.setVisible(true);

	}

	public void printSpielerNamen() {

	}

	public void printComputerSpielerDialog(int i) {

	}

	public void printSpielerdialog() {

	}

	public void printWelcome() {

	}

	public void printWurf(Wurf wurf) {

	}

	public void printErgebnisspalte(Spieler spieler) {

	}

}
