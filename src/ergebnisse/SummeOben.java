package ergebnisse;

import logic.*;

/**TODO============================ Eventuell abfrage, ob der wert zwischen 1 und 6 ist
 * 
 */
public class SummeOben extends Ergebnis {
    protected int wert;
    
    /**
     * 
     */
    public SummeOben(int wert) {
        this.wert=wert;
        oben=true;
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
     * @return true wenn der Wurf die Bedingung erfüllt
     */
    @Override
    public boolean ueberpruefen(Wurf wurf) {
        if(gestrichen||summe!=0){
            return false;
        }
        for(Wuerfel w : wurf.getAlleWuerfel()){
            if(w.getAugenzahl()==wert){
                return true;
            }
        }
        return false;
    }


  


    
}