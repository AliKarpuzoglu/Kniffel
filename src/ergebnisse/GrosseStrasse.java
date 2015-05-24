package ergebnisse;

import java.util.*;

import logic.Wurf;

/**
 * 
 */
public class GrosseStrasse extends Ergebnis {

    /**
     * 
     */
    public GrosseStrasse() {
        oben = false;
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return aufsteigendeZahlen(wurf) == 5;
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 40;
        } else {
            return 0;
        }
    }

}
