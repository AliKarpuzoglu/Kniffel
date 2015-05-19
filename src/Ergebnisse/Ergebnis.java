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
        DREIER, VIERER, FUENFER, SECHSER;
        
        
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
    public boolean ueberpruefen(Wurf wurf) {
        switch (this.name) {
        case DREIERPASCH:
            return wurf.gleicheZahlen() >= 3;
        case QUADRATFOLGE:
            boolean eins = false;
            boolean zwei = false;
            boolean vier = false;

            for (int i = 0; i < wurf.getAlleWuerfel().length; i++) {
                Wuerfel temp = wurf.getAlleWuerfel()[i];
                if (temp.getAugenzahl() == 1) {
                    eins = true;
                }
                if (temp.getAugenzahl() == 2) {
                    zwei = true;
                }
                if (temp.getAugenzahl() == 4) {
                    vier = true;
                }

            }
            return eins && zwei && vier;
        case VIERERPASCH:
            return wurf.gleicheZahlen() >= 4;
        case FULLHOUSE:
            return false; // TODO
        case GROSSESTRASSE:
            return false; // TODO
        case KLEINESTRASSE:
            return false; // TODO
        case KNIFFEL:
            return false; // TODO
        default:
            return false;
        }
    }

    /**
     * @param wurf
     */
    public int punkteBerechnen(Wurf wurf) {
        switch (this.name) {
        case DREIERPASCH:
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