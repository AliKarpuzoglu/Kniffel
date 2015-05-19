package Ergebnisse;

import java.util.*;

import Logic.*;

/**
 * 
 */
public class Ergebnis {

    public enum ErgebnisName {
        DREIERPASCH, FULLHOUSE, GROSSESTRASSE, KLEINESTRASSE, 
        KNIFFEL, QUADRATFOLGE, VIERERPASCH, EINER, ZWEIER, 
        DREIER, VIERER, FUENFER, SECHSER, NULLEN;
        
        
    }

    private ErgebnisName name;

    /**
     * 
     */
    protected int summe;

    protected boolean gestrichen;

    /**
     * 
     */
    public Ergebnis(ErgebnisName name) {
        this.name = name;
    }

    public int getSumme() {
        return summe;
    }

    public boolean isGestrichen() {
        return gestrichen;
    }

    /**
     * @param wurf
     */
    public int punkteBerechnen(Wurf wurf) {
        switch (this.name) {
        case DREIERPASCH:
            if(!wurf.checkDreierPasch()){
                return 0;
            }
            int temp = 0;
            for (Wuerfel w : wurf.getAlleWuerfel()) {
                temp = w.getAugenzahl() + temp;
            }
            return temp;
        default:
            return 0;
        }
    }

    public void punkteAnrechnen(Wurf wurf) {

    }

   
    

}