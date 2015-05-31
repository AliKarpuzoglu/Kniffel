package ergebnisse;

import java.util.*;
import logic.*;

import logic.Wurf;

/**
 * 
 * @author Katharina, Ali, Fritz and André
 *
 * In dieser Klasse werden zwei Methoden aufgerufen, die dazu dienen, den Wurf zu überprüfen ob es
 * tatsaechlich um ein "FullHouse" handelt, und dann werden die erreichten Punkte berechnet.
 * 
 */
public class Fullhouse extends Ergebnis {

    
    public Fullhouse() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        Wuerfel[] temp = wurf.getAlleWuerfel();
        return gleicheZahlen(wurf) ==3&&
                !gestrichen&&summe==0
                && 
                ((temp[0].equals(temp[1]) &&(temp[0].equals(temp[2])) && (temp [3].equals(temp[4]))) 
                        || 
                ((temp[0].equals(temp[1])) &&(temp[2].equals(temp[3])) && (temp[2].equals(temp[4]))))
                ;
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 25;
        } else {
            return 0;
        }
    }

   

}