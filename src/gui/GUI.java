package gui;

import Logic;

import java.util.Scanner;

import logic.ComputerSpieler;

public class GUI {
	String[] spieler = new String[6];
	int i = 0, r = 0;

	public void printReihenfolge(Spieler[] spieler) {
		System.out.println("Die Reihenfolge der Spieler ist:");
		for (int i = 0; i < spieler.length; i++) {
			System.out.println((i + 1) + ": " + spieler[i].toString());
		}
	}

	public void printSpielerNamen() {

		for (int z = 0; z < spieler.length; z++) {
			System.out.println("" + spieler[z]);
		}

	}

	public void printComputerSpielerDialog(int i) {
		Scanner computer = new Scanner(System.in);
		System.out.printf("Wie viele Computerspieler sollen teilnehmen?");
		int anzahlComp = computer.nextInt();
		for (int tre = 0; tre <= anzahlComp; tre++) {
			spieler[i] = new String("Computer Spieler");
			System.out.println("" + spieler[i]);
		}
		computer.close();

	}

	public void printSpielerdialog() {

		Scanner scanner = new Scanner(System.in);
		Scanner anzahl = new Scanner(System.in);
		System.out.println("Es duerfen bis zu 6 Spieler teilnehmen");
		System.out
				.println("Bitte geben sie die Anzahl der menschlichen Spieler an(1-6)");
		r = anzahl.nextInt();

		while (i <= r) {
			System.out
					.printf("Bitte geben sie den Namen des naechsten Spielers ein.");
			spieler[i] = scanner.next();
			i++;
		}
		scanner.close();
		anzahl.close();

	}

	public void printWelcome() {
		System.out.println("Willkommen zu Kniffel");
		System.out
				.println("Die Gruppe um Jonas Jaeckel wuenscht ihnen ein erfreuliches Spiel");
	}

	public void printWurf(Wurf wurf) {
		System.out.println(wurf.toString());

	}

	/**
	 * @param spieler
	 */
	public void printErgebnisspalte(Spieler spieler) {

		for (int u = 0; u < spieler.lenght(); u++) {
			System.out.println("| " + spieler[u] + " | " + EINER.getSumme
					+ " | " + ZWEIER.getSumme + " | " + DREIER.getSumme + " | "
					+ VIERER.getSumme + " | " + FÜNFER.getSumme + " | "
					+ SECHSER.getSumme + " | " + summeOben() + " | "
					+ BONUS.getSumme() + " | " + DREIERPASCH.getSumme + " | "
					+ VIERERPASCH.getSumme + " | " + QUADRATFOLGE.getSummer
					+ " | " + DREIER.getSumme + " | " + VIERER.getSumme + ""
					+ FULLHOUSE.getSummme + " | " + KLEINESTRASSE.getSumme
					+ " | " + GROSSESTRASSE.getSumme + " | " + VIERER.getSumme
					+ " | " + KNIFFEL.getSumme + " | " + CHANCE.getSumme
					+ " | " + summeUnten() + " | " + getGesamtSumme());
		}
	}

}