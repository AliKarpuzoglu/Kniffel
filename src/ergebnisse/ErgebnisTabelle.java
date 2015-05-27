package ergebnisse;

/**
 * 
 */
public class ErgebnisTabelle {

	/**
	 * TODO: output bonus
	 * 
	 */
	public ErgebnisTabelle() {
		for (int i = 0; i < 6; i++) {
			ergebnisse[i] = new SummeOben(i+1);
		}
		ergebnisse[6] = new Dreierpasch();
		ergebnisse[7] = new Viererpasch();
		ergebnisse[8] = new Quadratfolge();
		ergebnisse[9] = new Fullhouse();
		ergebnisse[10] = new KleineStrasse();
		ergebnisse[11] = new GrosseStrasse();
		ergebnisse[12] = new Kniffel();
		ergebnisse[13] = new Chance();

	}

	/**
     * 
     */
	private Ergebnis[] ergebnisse = new Ergebnis[14];

	/**
     * 
     */
	private final int BONUS = 35;

	/**
	 * TODO: gebe die tabelle aus: beachten!!!!! Bonus, summeoben, summeunten,
	 * summegesamt
	 * 
	 * @return
	 * 
	 */
	public String toString() {
		String ausgabe = " | " + ergebnisse[0] + " | " + ergebnisse[1] + " | "
				+ ergebnisse[2] + " | " + ergebnisse[3] + " | " + ergebnisse[4]
				+ " | " + ergebnisse[5] + " | " + getSummeOben() + " | "
				+ getBonus() + " | " + ergebnisse[6] + " | " + ergebnisse[7]
				+ " | " + ergebnisse[8] + " | " + ergebnisse[9] + " | "
				+ ergebnisse[10] + " | " + ergebnisse[11] + " | " + ergebnisse[12]
				+ " | " + ergebnisse[13] + " | " + getSummeUnten() + " | "
				+ getGesamtSumme();
		return ausgabe;
	}

	/**
     * 
     */

//	public void ergebnisEintragen(Ergebnis ergebnis) {
//		for (Ergebnis e : ergebnisse) {
//			if (e.getClass().equals(ergebnis.getClass())) {
//			    if(e.getClass()==SummeOben.class){
//			        if(((SummeOben)e).wert==((SummeOben)ergebnis).wert){
//			            e=ergebnis;
//			        }
//			        
//			    }
//				e = ergebnis;
//			}
//		}
//	}


	/**
     * 
     */
	public int getSummeOben() {
		int temp = 0;
		for (int i = 0; i < 6; i++) {
			temp += ergebnisse[i].getSumme();
		}
		return temp;
	}

	/**
     * 
     */
	public int getSummeUnten() {
		int temp = 0;
		for (int i = 6; i < ergebnisse.length; i++) {
			temp += ergebnisse[i].getSumme();
		}
		return temp;
	}

	public int getBonus() {
		return getSummeOben() >= 63 ? BONUS : 0;
	}

	/**
     * 
     */
	public int getGesamtSumme() {
		int temp = getSummeOben() + getSummeUnten();
		return getSummeOben() >= 63 ? temp + BONUS : temp;
	}

	public Ergebnis[] getErgebnis() {
		return ergebnisse;
	}
/*
	public static void main(String[] args) {
		ErgebnisTabelle e = new ErgebnisTabelle();
		for (int i = 0; i < e.ergebnisse.length; i++) {
			System.out.println(e.ergebnisse[i]);
		}
	}
*/
}