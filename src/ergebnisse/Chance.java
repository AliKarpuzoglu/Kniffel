package ergebnisse;

import logic.Wuerfel;
import logic.Wurf;

/**
 * 
 * @author Katharina, Ali, Fritz and Andr�
 * 
 * In dieser Klasse werden zwei Methoden aufgerufen, die dazu dienen, den Wurf zu �berpr�fen ob es
 * tatsaechlich eine "Chance" ist, und dann werden die erreichten Punkte berechnet. 
 *
 */

public class Chance extends Ergebnis {
	

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return !gestrichen&&summe==0;
    }
    
    

    
    public String getName(){
        return "Chance";
    }
    
    @Override
    public int punkteBerechnen(Wurf wurf) {
        int temp = 0;
        for (Wuerfel w : wurf.getAlleWuerfel()) {
            temp = w.getAugenzahl() + temp;
        }
        return temp;
    }

   
}
