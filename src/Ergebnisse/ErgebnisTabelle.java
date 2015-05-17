package Ergebnisse;

public class ErgebnisTabelle {
	private int summeGesamt;
	private int summeUnten;
	private final int BONUS = 35;
	private int summeOben;

	public ErgebnisTabelle() {
		for (int i = 1; i <= 6; i++) {
			ergebnis[i - 1] = new SummeOben(i);
		}
		ergebnis[6] = new Dreierpasch();

	}

	private Ergebnis[] ergebnis;

	public void tabelleAnzeigen() {
		// TODO implement here
	}

	public void gesamtSumme() {
		// TODO implement here
	}

	@Override
	public String toString() {
		return null;
		// TODO implement here
	}

	public void ergebnisEintragen() {
		// TODO implement here
	}

	public void berechneOben() {
		// TODO implement here
	}

	public void berechneUnten() {
		// TODO implement here
	}

	public int getSummeOben() {
		return summeOben;
	}

	public void setSummeOben(int summeOben) {
		this.summeOben = summeOben;
	}

	public int getSummeUnten() {
		return summeUnten;
	}

	public void setSummeUnten(int summeUnten) {
		this.summeUnten = summeUnten;
	}

	public int getSummeGesamt() {
		return summeGesamt;
	}

	public void setSummeGesamt(int summeGesamt) {
		this.summeGesamt = summeGesamt;
	}

}