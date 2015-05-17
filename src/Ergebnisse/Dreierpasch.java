package Ergebnisse;


import Logic.*;

public class Dreierpasch extends Ergebnis {

	/**
     * 
     */
	public Dreierpasch() {
		super("Dreierpasch", 9, false);
	}

	@Override
	public boolean ueberpruefen(Wurf wurf) {
		return super.gleicheZahlen(wurf) >= 3;
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

	@Override
	public boolean ueberpruefen(Wurf[] wurf) {
		// TODO Auto-generated method stub
		return false;
	}

}