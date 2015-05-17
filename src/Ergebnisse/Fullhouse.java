package Ergebnisse;
import java.util.*;

import Logic.Wuerfel;
import Logic.Wurf;

/**
 * 
 */
public class Fullhouse extends Ergebnis {

    /**
     * 
     */
    public Fullhouse() {
    	oben = false;
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        // TODO Auto-generated method stub
        return false;
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