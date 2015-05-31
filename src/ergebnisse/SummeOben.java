package ergebnisse;

import logic.*;

/**
 * 
 * @author Katharina, Ali, Fritz and Andr�
 * 
 * Berechnet die Summe Oben, das hei�t das Programm rechnet die oben erzielten Punkte zusammen
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
     * Berechnet die moeglichen Punkte, die dieser Wurf geben wuerde
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
     * @return true wenn der Wurf die Bedingung erfuellt
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
    public int getWert(){
        return wert;
    }

    public String getName(){
        return this.wert+"er";
    }
  


    
}