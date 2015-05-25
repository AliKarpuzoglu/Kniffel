package ergebnisse;

import java.util.*;

import logic.Wurf;

/**
 * 
 */
public class Kniffel extends Ergebnis {

    /**
     * 
     */
    public Kniffel() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return gleicheZahlen(wurf) == 5 &&!gestrichen;
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 50;
        } else {
            return 0;
        }    }

  

}