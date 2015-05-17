package Ergebnisse;

import java.util.*;

import Logic.Wuerfel;
import Logic.Wurf;

/**
 * 
 */
public class GrosseStrasse extends Ergebnis {

    /**
     * 
     */
    public GrosseStrasse() {
        oben=false;
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
    	
    	
        return false;
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
    	 int temp=0;
         for(Wuerfel w: wurf.getAlleWuerfel()){
             temp=w.getAugenzahl()+temp;
         }
         return 40;
    }

    @Override
    public void punkteAnrechnen(Wurf wurf) {
    	 summe=punkteBerechnen(wurf);
    }

}