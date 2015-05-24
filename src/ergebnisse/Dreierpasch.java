package ergebnisse;

import logic.Wuerfel;
import logic.Wurf;

/**
 * 
 */
public class Dreierpasch extends Ergebnis {

    /**
     * 
     */
    public Dreierpasch() {
        oben = false;
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return super.gleicheZahlen(wurf) >= 3;
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