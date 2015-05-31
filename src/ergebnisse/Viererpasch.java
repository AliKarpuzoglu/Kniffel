package ergebnisse;

import java.util.*;

import logic.*;

/**
 * 
 * @author Katharina, Ali, Fritz and Andr�
 * 
 * In dieser Klasse werden zwei Methoden aufgerufen, die dazu dienen, den Wurf zu �berpr�fen ob es sich
 * tatsaechlich um einen "Viererpasch" handelt, und dann werden die erreichten Punkte berechnet.
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
        return super.gleicheZahlen(wurf) >= 4&&!gestrichen&&summe==0;
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
    public String getName(){
        return "Viererpasch";
    }

}