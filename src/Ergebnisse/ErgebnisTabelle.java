package Ergebnisse;

import java.util.*;

/**
 * 
 */
public class ErgebnisTabelle {

    /**
     * 
     */
    public ErgebnisTabelle() {
        for(int i=1;i<=6;i++){
            ergebnis[i-1] = new SummeOben(i);
        }
        ergebnis[6]= new Dreierpash();
        
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
    public void ergebnisEintragen() {
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

}