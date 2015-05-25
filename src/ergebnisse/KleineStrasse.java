package ergebnisse;

import logic.Wurf;

/**
 * 
 */
public class KleineStrasse extends Ergebnis {

    /**
     * 
     */
    public KleineStrasse() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return aufsteigendeZahlen(wurf) >= 4 &&!gestrichen;

    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 30;
        } else {
            return 0;
        }
    }

}