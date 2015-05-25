package ergebnisse;

import java.util.*;
import logic.*;

import logic.Wurf;

/**
 * 
 */
public class Fullhouse extends Ergebnis {

    /**
     * 
     */
    public Fullhouse() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        Wuerfel[] temp = wurf.getAlleWuerfel();
        return gleicheZahlen(wurf) ==3&&!gestrichen
                && 
                ((temp[0].equals(temp[1]) &&(temp[0].equals(temp[2])) && (temp [3].equals(temp[4]))) 
                        || 
                ((temp[0].equals(temp[1])) &&(temp[2].equals(temp[3])) && (temp[2].equals(temp[4]))))&&summe==0;
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 25;
        } else {
            return 0;
        }
    }

   

}