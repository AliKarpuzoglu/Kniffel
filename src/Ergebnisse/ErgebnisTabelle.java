package Ergebnisse;

import java.util.*;

/**TODO : Change "ergebnis" to "ergebnisse"?
 *
 */
public class ErgebnisTabelle {

    /**
     *
     */
    public ErgebnisTabelle() {
        for (int i = 1; i <= 6; i++) {
            ergebnis[i - 1] = new SummeOben(i);
        }
        ergebnis[6] = new Dreierpasch();
        ergebnis[7] = new Viererpash();
        ergebnis[8] = new Quadratfolge();
        ergebnis[9] = new FullHouse();
        ergebnis[10] = new KleineStrasse();
        ergebnis[11] = new GrosseStrasse();
        ergebnis[12] = new Kniffel();
        ergebnis[13] = new Chance();

    }

    /**
     *
     */
    private Ergebnis[] ergebnis;

    /**
     *
     */
    private final int BONUS = 35;

    /**
     *
     */
    private int summeOben;

    /**
     *
     */
    private int summeUnten;

    /**
     *
     */
    private int summeGesamt;

    /**
     *
     */
    public void tabelleAnzeigen() {
        // TosTring
    }

    /**
     *
     */
    public void gesamtSumme() {
        for (Ergebnis e :ergebnis ) {

        }
    }

    /**
     *
     */
    public void toString() {
        // TODO implement here
    }

    /**
     *
     */
    public void ergebnisEintragen(Ergebnis ergebnis) {
        // TODO implement here
    }

    /**
     *
     */
    public void berechneOben() {
        // TODO implement here
    }

    /**
     *
     */
    public void berechneUnten() {
        // TODO implement here
    }

    public Ergebnis[] getErgebnis(){
        return ergebnis;
    }

}
