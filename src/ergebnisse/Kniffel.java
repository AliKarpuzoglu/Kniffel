package ergebnisse;

import java.util.*;

import logic.Wurf;

/**
 * 
 * @author Katharina, Ali, Fritz and Andr�
 * 
 * In dieser Klasse werden zwei Methoden aufgerufen, die dazu dienen, den Wurf zu �berpr�fen ob es sich
 * tatsaechlich um ein "Kniffel" handelt, und dann werden die erreichten Punkte berechnet.
 *
 */
public class Kniffel extends Ergebnis {

    public Kniffel() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return (gleicheZahlen(wurf) == 5) &&(!gestrichen)&&(summe==0);
        
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 50;
        } else {
            return 0;
        }    }
 


    public String getName(){
        return "Kniffel";
    }
}