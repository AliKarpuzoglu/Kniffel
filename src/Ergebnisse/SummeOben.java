package Ergebnisse;

import java.util.*;
import Logic.*;

/**TODO============================ Eventuell abfrage, ob der wert zwischen 1 und 6 ist
 * 
 */
public class SummeOben extends Ergebnis {
    private int wert;
    

    public SummeOben(int wert) {
    	super("Summe oben", wert, true);
        this.wert=wert;
    }
    
    /**
     * rechnet aus, wie viele punkte dieser Wurf theoretisch geben würde.
     */
    @Override
    public int punkteBerechnen(Wurf wurf) {
        int zusammen=0;
        for(Wuerfel w: wurf.getAlleWuerfel()){
            if(w.getAugenzahl()==wert){
                zusammen = zusammen + w.getAugenzahl();
            }
        }
        return zusammen;
        
    }
    
    /**
     * rechnet sich die punkte an
     */
    @Override
    public void punkteAnrechnen(Wurf wurf){
        this.summe=punkteBerechnen(wurf);
    }
    
    /**
     * @return true wenn der Wurf die Bedingung erfüllt
     */
    @Override
    public boolean ueberpruefen(Wurf wurf) {
        for(Wuerfel w : wurf.getAlleWuerfel()){
            if(w.getAugenzahl()==wert){
                return true;
            }
        }
        return false;
    }


  


    
}