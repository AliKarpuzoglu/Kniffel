package logic;


import java.util.*;

import ergebnisse.*;
import ergebnisse.Ergebnis.*;

public class ComputerSpieler extends Spieler {

	public static int playerCounter = 1;

	public ComputerSpieler() {
		super("Computer Spieler " + playerCounter++);

	}

	/**
	 * starte den Prozess, das beste Ergebnis zu finden
	 */
	public void ergebnisAuswaehlen() {
		runde = 1;
		for (Wuerfel w : wurf.getAlleWuerfel()) {
			w.wiederReinholen();
		}
		ergebnisAuswaehlenHelper1();
	}

	/**
	 * Finde das beste Ergebnis und Wuerfel erneut
	 * 
	 */
	private void ergebnisAuswaehlenHelper1() {

		if (runde >= 5) {
			ergebnisAuswaehlenHelper();
			return;
		}
		if (alleWuerfelBeiseite()) {
			ergebnisAuswaehlenHelper();

			return;

		}

		ArrayList<Ergebnis> moeglich = new ArrayList<>();

		// fullhouse
		if (ergebnisTabelle.getErgebnis()[9].ueberpruefen(wurf)) {
			kiErgebnisEintragen(ergebnisTabelle.getErgebnis()[9]);

			return;
		}

		// gro�e stra�e
		if (ergebnisTabelle.getErgebnis()[11].ueberpruefen(wurf)) {
			kiErgebnisEintragen(ergebnisTabelle.getErgebnis()[11]);
			return;
		}

		// kleine Stra�e
		if (ergebnisTabelle.getErgebnis()[10].ueberpruefen(wurf)) {
			kiErgebnisEintragen(ergebnisTabelle.getErgebnis()[10]);
			return;
		}

		for (Ergebnis e : ergebnisTabelle.getErgebnis()) {

			if (e.ueberpruefen(wurf)) {
				moeglich.add(e);
			}
		}
		// wenn das mit den meisten Punkten eine Summe Oben ist:
		if (maxMoeglich(moeglich) != null) {
			if (maxMoeglich(moeglich).isOben()) {

				if (runde < 5) {
					// lege alle anderen w�rfel weg
					for (Wuerfel w : wurf.getAlleWuerfel()) {
						if (w.getAugenzahl() == ((SummeOben) maxMoeglich(moeglich))
								.getWert()) {
							w.beiseiteLegen();
						}

					}
					wurf.wuerfeln();
					System.out.println(wurf); //such bm, much wow
					runde++;
					ergebnisAuswaehlenHelper1();
					return;

				}
			}
		}

		if (Ergebnis.gleicheZahlen(wurf) >= 2) {
			int maxGleich = meisteAugen(wurf);
			for (int i = 0; i < 6; i++) {
				// wenn das, was am meisten vorhanden ist, nicht offen ist, leg
				// einen anderne zur Seite
				if (maxGleich == ((SummeOben) ergebnisTabelle.getErgebnis()[i])
						.getWert()
						&& !ergebnisTabelle.getErgebnis()[i].ueberpruefen(wurf)) {
					wurf.wuerfelWeglegen(wurf.getAlleWuerfel()[runde]);
					wurf.wuerfeln();
					System.out.println(wurf);
					runde++;
					ergebnisAuswaehlenHelper1();
					return;

				}
			}
			if (runde < 5) {
				// lege alle passenden w�rfel weg
				for (Wuerfel w : wurf.getAlleWuerfel()) {
					if (w.getAugenzahl() == maxGleich) {
						w.beiseiteLegen();
					}

				}
				wurf.wuerfeln();
				System.out.println(wurf);
				runde++;
				ergebnisAuswaehlenHelper1();
				return;

			}
		} // wenn nix m�glich ist, reroll die Hand

		if (runde < 5) {
			wurf.wuerfelWeglegen(wurf.getAlleWuerfel()[runde - 1]);
			wurf.wuerfeln();
			System.out.println(wurf);
			runde++;
			ergebnisAuswaehlenHelper1();
			return;
		}

		ergebnisAuswaehlenHelper1();
	}

	/**
	 * gebe die augenzahl zur�ck die am meisten vor kommt
	 * 
	 * @param w
	 * @return
	 */
	private int meisteAugen(Wurf w) {
		int count = 1, tempCount;
		int popular = w.getAlleWuerfel()[0].getAugenzahl();
		int temp = 0;
		for (int i = 0; i < (w.getAlleWuerfel().length - 1); i++) {
			temp = w.getAlleWuerfel()[i].getAugenzahl();
			tempCount = 0;
			for (int j = 1; j < w.getAlleWuerfel().length; j++) {
				if (temp == w.getAlleWuerfel()[j].getAugenzahl())
					tempCount++;
			}
			if (tempCount > count) {
				popular = temp;
				count = tempCount;
			}
		}
		return popular;
	}

	private boolean alleWuerfelBeiseite() {
		Wuerfel[] temp = wurf.getAlleWuerfel();
		return temp[0].isWeggelegt() && temp[1].isWeggelegt()
				&& temp[2].isWeggelegt() && temp[3].isWeggelegt()
				&& temp[4].isWeggelegt();
	}

	private void holeAlleWuerfel() {
		for (Wuerfel w : wurf.getAlleWuerfel()) {
			w.wiederReinholen();
		}
	}

	/**
	 * 
	 * @param moeglich
	 * @return das Ergebnis, dass die meisten punkte geben wuerde
	 */
	private Ergebnis maxMoeglich(ArrayList<Ergebnis> moeglich) {

		Ergebnis beste = null;
		Ergebnis chance = null;
		int max = 0;
		for (Ergebnis e : moeglich) {
			if (e.ueberpruefen(wurf)) {
				// UND E KEINE CHANCE IST!
				if (e.punkteBerechnen(wurf) >= max && !(e instanceof Chance)) {
					max = e.punkteBerechnen(wurf);
					beste = e;
				}
				if (e instanceof Chance) {
					chance = e;
				}
			}
		}
		if (beste == null && chance != null) {
			if (chance.ueberpruefen(wurf)) {
				beste = chance;
			}
		}
		return beste;
	}

	/**
	 * Trage das Ergebnis ein
	 * 
	 * @param e
	 *            das Ergebnis das man Eintragen soll
	 */
	private void kiErgebnisEintragen(Ergebnis e) {

		if (e == null) {
			kiStreicheErgebnis();
			return;
		}
		holeAlleWuerfel();

		e.punkteAnrechnen(wurf);

	}

	/**
	 * wenn kein Ergebnis eingetragen werden soll, streiche das erste freie
	 * Ergebnis
	 */
	private void kiStreicheErgebnis() {
		for (Ergebnis e : ergebnisTabelle.getErgebnis())
			if (!e.isGestrichen() && e.getSumme() == 0) {
				e.streiche();
				return;
			}
	}

	/**
	 * waehlt das passende Ergebnis aus, dass die meisten Punkte zu dem Wurf
	 * liefert
	 * 
	 * @param wurf
	 *
	 */
	private void ergebnisAuswaehlenHelper() {
		int max = 0;
		Ergebnis beste = null;
		Ergebnis chance = null;
		for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
			if (e.ueberpruefen(wurf)) {
				if (e.punkteBerechnen(wurf) > max && !(e instanceof Chance)) {
					max = e.punkteBerechnen(wurf);
					beste = e;
				}
				if (e instanceof Chance) {
					chance = e;
				}
			}
		}
		// chance als letztes ausw�hlen
		if (beste == null && chance != null) {
			if (chance.ueberpruefen(wurf)) {
				beste = chance;
			}
		}
		kiErgebnisEintragen(beste);

	}

}