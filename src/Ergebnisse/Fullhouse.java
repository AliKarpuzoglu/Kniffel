package Ergebnisse;
import java.util.*;

import Logic.Wuerfel;
import Logic.Wurf;

/**
 * 
 */
public class Fullhouse extends Ergebnis {

    /**
     * schauen ob die ersten zwei oder die letzten zwei zahlen gleich sind
     */
    public Fullhouse() {
    	oben = false;
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
    	
    	Wuerfel[] temp = wurf.getAlleWuerfel();
        
        return super.gleicheZahlen(wurf) ==3&& ((equals(temp [1]) == equals(temp [2]) && equals(temp[1]) == equals(temp[3]) && equals(temp [4]) == equals (temp[5]) || ( equals(temp[1]) ==  equals(temp[2]) &&  equals(temp [1]) ==  equals(temp [3]) &&  equals(temp[4])==  equals(temp[5]))));
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
    	int temp=0;
        for(Wuerfel w: wurf.getAlleWuerfel()){
            temp=w.getAugenzahl()+temp;
        }
        return temp;
    }

    @Override
    public void punkteAnrechnen(Wurf wurf) {
        summe = punkteBerechnen(wurf);
        
    }

}