package Ergebnisse;

import Logic.*;

public abstract class Ergebnis {

	protected String name;
	protected int summe;
	protected boolean oben;

	public Ergebnis(String name, int summe, boolean oben) {
		this.name = name;
		this.summe = summe;
		this.oben = oben;
	}

	public abstract boolean ueberpruefen(Wurf wurf);

	public abstract int punkteBerechnen(Wurf wurf);

	public abstract void punkteAnrechnen(Wurf wurf);

	public abstract boolean ueberpruefen(Wurf[] wurf);

	public static int gleicheZahlen(Wurf wurf) {
		int gleicheZahlen = 1;
		Wuerfel[] temp = wurf.getAlleWuerfel();// CHECK IF THIS IS
												// OKAYY!!!!!!!!!!!!!!!!!!!
		for (int i = 1; i < temp.length; i++) {
			int momentan = 1;
			while (i < temp.length
					&& temp[i - 1].getAugenzahl() == temp[i].getAugenzahl()) {
				momentan++;
				i++;
			}
			if (gleicheZahlen < momentan) {
				gleicheZahlen = momentan;
			}
		}
		return gleicheZahlen;

	}

	public static int aufsteigendeZahlen(Wurf wurf) {
		int gleicheZahlen = 1;
		Wuerfel[] temp = wurf.getAlleWuerfel();// CHECK IF THIS IS
												// OKAYY!!!!!!!!!!!!!!!!!!!
		for (int i = 1; i < temp.length; i++) {
			int momentan = 1;
			while (i < temp.length
					&& temp[i - 1].getAugenzahl() + 1 == temp[i].getAugenzahl()) {
				momentan++;
				i++;
			}
			if (gleicheZahlen < momentan) {
				gleicheZahlen = momentan;
			}
		}
		return gleicheZahlen;

	}

}