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
        // TODO implement here
    }

    /**
     * 
     */
    public void gesamtSumme() {
        // TODO implement here
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