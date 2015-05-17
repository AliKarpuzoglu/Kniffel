package Ergebnisse;

import java.util.*;

import Logic.*;

/**
 * 
 */
public class Viererpash extends Ergebnis {

	/**
     * 
     */
	public Viererpash() {
		super("Viererpasch", 16, false);
	}

	@Override
	public boolean ueberpruefen(Wurf wurf) {
		return super.gleicheZahlen(wurf) >= 4;
	}

	@Override
	public int punkteBerechnen(Wurf wurf) {
		int temp = 0;
		for (Wuerfel w : wurf.getAlleWuerfel()) {
			temp = w.getAugenzahl() + temp;
		}
		return temp;
	}

	@Override
	public void punkteAnrechnen(Wurf wurf) {
		summe = punkteBerechnen(wurf);
	}

}