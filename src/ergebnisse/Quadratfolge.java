package ergebnisse;

import logic.Wurf;

/**
 * 
 * @author Katharina, Ali, Fritz and Andr�
 * 
 * In dieser Klasse werden zwei Methoden aufgerufen, die dazu dienen, den Wurf zu �berpr�fen ob es sich
 * tatsaechlich um eine "Quadratfolge" handelt, und dann werden die erreichten Punkte berechnet.
 *
 */
public class Quadratfolge extends Ergebnis {

    
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

    public String getName(){
        return "Quadratfolge";
    }
}