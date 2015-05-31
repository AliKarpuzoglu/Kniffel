package ergebnisse;

import logic.Wurf;

/**
 * 
 * @author Katharina, Ali, Fritz and Andr�
 * 
 * In dieser Klasse werden zwei Methoden aufgerufen, die dazu dienen, den Wurf zu �berpr�fen ob es sich
 * tatsaechlich um eine "KleineStrasse" handelt, und dann werden die erreichten Punkte berechnet.
 */
public class KleineStrasse extends Ergebnis {

    
    public KleineStrasse() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return (aufsteigendeZahlen(wurf) >= 4) && (!gestrichen) && (summe==0);

    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 30;
        } else {
            return 0;
        }
    }

    public String getName(){
        return "KleineStrasse";
    }

}