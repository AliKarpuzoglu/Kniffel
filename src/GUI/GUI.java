package GUI;

import Logic;

import java.util.Scanner;

import logic.ComputerSpieler;

public class GUI {
	Scanner scanner = new Scanner(System.in);

	public void printReihenfolge(Spieler[] spieler) {
		System.out.println("Die Reihenfolge der Spieler ist:");
		for (int i = 0; i < spieler.length; i++) {
			System.out.println((i + 1) + ": " + spieler[i].toString());
		}
	}

	public void printSpielerNamen() {
		String[] spieler = new String[6];
		int i = 0;

		while (true) {
			System.out
					.printf("Bitte geben sie den Namen des naechsten Spielers ein. Oder 'ende' , wenn sich alle Spieler eingetragen haben.");
			spieler[i] = scanner.next();
			i++;
			if (spieler.equals("ende"))
				break;
		}
		for (int h = 0; h < spieler.length; h++) {
			System.out.println("" + spieler[h]);
			if (i <= 6) {
				spieler[i] = new String("Computer Spieler");

			}

			for (int g = 0; g <= spieler.length; g++) {
				System.out.println("Die Spieler sind: \n" + spieler[g] + ",");
			}

			scanner.close();
		}

	}

	public void printComputerSpielerDialog(int i) {
		System.out.printf(
				"Wie viele Computerspieler sollen teilnehmen?(0-%d)/n", i);
	}

	public void printSpielerdialog() {
		System.out.println("Es dürfen bis zu 6 Spieler teilnehmen");
		System.out
				.println("Bitte geben sie die Anzahl der menschlichen Spieler an(1-6)");
	}

	public void printWelcome() {
		System.out.println("Willkommen zu Kniffel");
		System.out
				.println("Die Gruppe um Jonas Jäkel wünscht ihnen ein erfreuliches Spiel");
	}

	public void printWurf(Wurf wurf) {
		System.out.println(wurf.toString());

	}

	/**
	 * @param spieler
	 */
	public void printErgebnisspalte(Spieler spieler) {
		// TODO implement here
	}

}