package Ergebnisse;

import java.util.*;

import Ergebnisse.Ergebnis.ErgebnisName;

/**TODO : Change "ergebnis" to "ergebnisse"?
 * 
 */
public class ErgebnisTabelle {

    /**
     * 
     */
    public ErgebnisTabelle() {
        ergebnis[0] = new Ergebnis(ErgebnisName.EINER);
        ergebnis[1] = new Ergebnis(ErgebnisName.ZWEIER);
        ergebnis[2] = new Ergebnis(ErgebnisName.DREIER);
        ergebnis[3] = new Ergebnis(ErgebnisName.VIERER);
        ergebnis[4] = new Ergebnis(ErgebnisName.FUENFER);
        ergebnis[5] = new Ergebnis(ErgebnisName.SECHSER);
        ergebnis[6] = new Ergebnis(ErgebnisName.DREIERPASCH);
        ergebnis[7] = new Ergebnis(ErgebnisName.VIERERPASCH);
        ergebnis[8] = new Ergebnis(ErgebnisName.QUADRATFOLGE);
        ergebnis[9] = new Ergebnis(ErgebnisName.FULLHOUSE);
        ergebnis[10] = new Ergebnis(ErgebnisName.KLEINESTRASSE);
        ergebnis[11] = new Ergebnis(ErgebnisName.GROSSESTRASSE);
        ergebnis[12] = new Ergebnis(ErgebnisName.KNIFFEL);

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
    public String toString() {
        return null;
    }

    /**
     * 
     */
    public void ergebnisEintragen(Ergebnis ergebnis) {
        // TODO implement here
    }

    /**
     * noch nštig?
     */
    public void berechneOben() {
        // TODO implement here
    }

    /**
     * noch nštig?
     */
    public void berechneUnten() {
        // TODO implement here
    }
    
    public Ergebnis[] getErgebnis(){
        return ergebnis;
    }

}