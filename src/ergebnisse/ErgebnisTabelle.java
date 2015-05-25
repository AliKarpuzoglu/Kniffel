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
            ergebnisse[i] = new SummeOben(i);
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
     * toString()
     */
    public void tabelleAnzeigen() {
        // TODO implement here
    }

    /**
     * TODO: gebe die tabelle aus: beachten!!!!! Bonus, summeoben, summeunten,
     * summegesamt
     * 
     * @return
     * 
     */
    public String toString() {
       return null;
    }

    /**
     * 
     */
    public void ergebnisEintragen(Ergebnis ergebnis) {
        for (Ergebnis e : ergebnisse) {
            if (e.getClass().equals(ergebnis.getClass())) {
                e = ergebnis;
            }
        }
    }

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
    
    public int getBonus(){
        return getSummeOben()>=63 ? 0:BONUS;
    }

    /**
     * 
     */
    public int getGesamtSumme() {
        int temp = getSummeOben() + getSummeUnten();
        return getSummeOben() >= 63 ? temp : temp + BONUS;
    }

    public Ergebnis[] getErgebnis() {
        return ergebnisse;
    }
    public static void main(String[] args) {
        ErgebnisTabelle e = new ErgebnisTabelle();
        for(int i = 0;i<e.ergebnisse.length;i++){
            System.out.println(e.ergebnisse[i]);
        }
    }
    

}