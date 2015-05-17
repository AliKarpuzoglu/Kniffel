package Logic;

import Ergebnisse.*;

import Ergebnisse.Ergebnis;

public class MenschlicheSpieler extends Spieler {

	private String spielerName;
	private Wurf spielerWurf;

	public MenschlicheSpieler(String spielerName, Wurf spielerWurf) {
		super(spielerName, spielerWurf);
	}

	/**
	 * @param wurf
	 * @return
	 */
	public Ergebnis ergebnisAuswaehlen(Wurf wurf) {
		
		return null;
	}

	public String getSpielerName() {
		return spielerName;
	}

	public void setSpielerName(String spielerName) {
		this.spielerName = spielerName;
	}

}