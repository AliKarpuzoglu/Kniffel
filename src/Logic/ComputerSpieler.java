package Logic;


import Ergebnisse.Ergebnis;

public class ComputerSpieler extends Spieler {

	private static Wurf computerWurf;

	public ComputerSpieler() {
		super("Computer Spieler", computerWurf);

	}

	/**
	 * @param wurf
	 * @return
	 */
	public Ergebnis optimiertesErgebnisAuswaehlen(Wurf wurf) {
		// TODO implement here
		return null;
	}

}