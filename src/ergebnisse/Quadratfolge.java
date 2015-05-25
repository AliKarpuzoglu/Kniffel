package ergebnisse;

import logic.Wurf;

/**
 * 
 */
public class Quadratfolge extends Ergebnis {

    /**
     * 
     */
    public Quadratfolge() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        Ergebnis einser = new SummeOben(1);
        Ergebnis zweier = new SummeOben(2);
        Ergebnis vierer = new SummeOben(4);
        return einser.ueberpruefen(wurf)&&zweier.ueberpruefen(wurf)&&vierer.ueberpruefen(wurf)&!gestrichen&&summe==0;
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 15;
        } else {
            return 0;
        }    }


}