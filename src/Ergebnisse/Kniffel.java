package Ergebnisse;

import java.util.*;

import Logic.Wuerfel;
import Logic.Wurf;

/**
 * 
 */
public class Kniffel extends Ergebnis {

    /**
     * hier mit 5 
     */
    public Kniffel() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
    	return super.gleicheZahlen(wurf)>=5;
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