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
        // ToString
    }


    /**AUSGABE FÜR DIE GUI
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

    /**VIELLEICHT AUF VOID SETZEN
     *
     */
    public int berechneOben() {
        int summe=0;
        for(int i =0;i<5;i++){
            summe+=ergebnis[i].getSumme();
        }
        return summe;
    }

    /**VIELLEICHT AUF VOID SETZEN
     *
     */
    public int berechneUnten() {
        int summe=0;
        for(int i=5;i<ergebnis.length;i++){
            summe+=ergebnis[i].getSumme();
        }
        return summe;
    }
    
    /**VIELLEICHT AUF VOID SETZEN
    *
    */
   public int gesamtSumme() {
       return berechneOben()+berechneUnten();
   }


    public Ergebnis[] getErgebnis(){
        return ergebnis;
    }
    
    
}
