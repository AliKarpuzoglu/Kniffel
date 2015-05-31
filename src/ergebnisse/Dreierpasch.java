package ergebnisse;

import logic.Wuerfel;
import logic.Wurf;

/**
 * 
 * @author Katharina, Ali, Fritz and Andr�
 *
 * In dieser Klasse werden zwei Methoden aufgerufen, die dazu dienen, den Wurf zu �berpr�fen ob es sich
 * tatsaechlich um einen "Dreierpasch" handelt, und dann werden die erreichten Punkte berechnet.
 */
public class Dreierpasch extends Ergebnis {

  
    public Dreierpasch() {
        oben = false;
    }

    public String getName(){
        return "Dreierpasch";
    }
    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return super.gleicheZahlen(wurf) >= 3 && !gestrichen&&summe==0;
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