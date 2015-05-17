package Ergebnisse;

import java.util.*;

import Logic.Wuerfel;
import Logic.Wurf;

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
        
        return super.gleicheZahlen(wurf) == 3 && ((temp [1]*1) && (temp[1]*2) && (temp [1]*4));
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
    	summe=punkteBerechnen(wurf);
    }

}