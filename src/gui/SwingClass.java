
package gui;

import javax.swing.*;

import logic.Spieler;
import logic.Wurf;

public class SwingClass {
	JFrame spielerNamen = new JFrame("Spieler");
	JPanel panel = new JPanel();
	JButton spielenButton = new JButton("Spielen");
	JButton abbruch = new JButton("Abbrechen");

	public void printReihenfolge(Spieler[] spieler) {

		for (int i = 0; i < spieler.length; i++) {
			panel.add(new JLabel(" " + spieler[i]));
		}
		panel.add(spielenButton);
		panel.add(abbruch);
		spielerNamen.pack();

		spielerNamen.setVisible(true);

	}

	public void printSpielerNamen() {

	}

	public void printComputerSpielerDialog(int i) {

	}

	public void printSpielerdialog() {

	}

	public void printWelcome() {

		JFrame willkommen = new JFrame("Willkommen zu Kniffel!");

		willkommen.setSize(500, 500);
		willkommen
				.add(new JLabel(
						"Die Gruppe um Jonas Jaeckel wuenscht ihnen ein erfreuliches Spiel"));
		willkommen.setVisible(true);

	}

	public void printWurf(Wurf wurf) {

	}

	public void printErgebnisspalte(Spieler spieler) {

	}

}

