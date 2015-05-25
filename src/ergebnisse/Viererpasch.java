package ergebnisse;

import java.util.*;

import logic.*;

/**
 * 
 */
public class Viererpasch extends Ergebnis {

    /**
     * 
     */
    public Viererpasch() {
        oben = false;
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return super.gleicheZahlen(wurf) >= 4&&!gestrichen;
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        int temp = 0;
        if (ueberpruefen(wurf)) {
            for (Wuerfel w : wurf.getAlleWuerfel()) {
                temp = w.getAugenzahl() + temp;
            }
        }
        return temp;
    }

}