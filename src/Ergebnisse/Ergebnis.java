package Ergebnisse;

import java.util.*;

import Logic.*;

/**
 * 
 */
public class Ergebnis {

    public enum ErgebnisName {
        DREIERPASCH, FULLHOUSE, GROSSESTRASSE, KLEINESTRASSE, KNIFFEL, QUADRATFOLGE, SUMMEOBEN, VIERERPASH
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
            return gleicheZahlen(wurf) >= 3;
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
        case SUMMEOBEN:
            for (Wuerfel w : wurf.getAlleWuerfel()) {
                if (w.getAugenzahl() == wert) { //have to find another way
                    return true;
                }
            }
            return false;
        case VIERERPASH : return gleicheZahlen(wurf)>=4;
        case FULLHOUSE:
            return false; // TODO
        case GROSSESTRASSE:
            return false; // TODO
        case KLEINESTRASSE:
            return false; //TODO
        case KNIFFEL:
            return false; //TODO
        default:
            return false;
        }
    }

    /**
     * @param wurf
     */
    public int punkteBerechnen(Wurf wurf) {
        return 0;
        // TODO
    }

    public void punkteAnrechnen(Wurf wurf) {

    }

    public int gleicheZahlen(Wurf wurf) {
        int gleicheZahlen = 1;
        Wuerfel[] temp = wurf.getAlleWuerfel();// CHECK IF THIS IS
                                               // OKAYY!!!!!!!!!!!!!!!!!!!
        for (int i = 1; i < temp.length; i++) {
            int momentan = 1;
            while (i < temp.length && temp[i - 1].getAugenzahl() == temp[i].getAugenzahl()) {
                momentan++;
                i++;
            }
            if (gleicheZahlen < momentan) {
                gleicheZahlen = momentan;
            }
        }
        return gleicheZahlen;

    }

    public int aufsteigendeZahlen(Wurf wurf) {
        int gleicheZahlen = 1;
        Wuerfel[] temp = wurf.getAlleWuerfel();// CHECK IF THIS IS
                                               // OKAYY!!!!!!!!!!!!!!!!!!!
        for (int i = 1; i < temp.length; i++) {
            int momentan = 1;
            while (i < temp.length && temp[i - 1].getAugenzahl() + 1 == temp[i].getAugenzahl()) {
                momentan++;
                i++;
            }
            if (gleicheZahlen < momentan) {
                gleicheZahlen = momentan;
            }
        }
        return gleicheZahlen;

    }

}