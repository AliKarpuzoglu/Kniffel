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

    /**
     * 
     * @param wurf
     * @return ueberprüft ob die zahlen 1 2 und 4 gewürfelt wurde.
     * die wurf methode ruft einen array auf ( getAlleWuerfel) und hier kann ich an jeder i-te stelle
     * zugreifen. temp dient dazu nicht immer getAlleWuerfel zu schreiben.. um dann auf die augenzahl
     * zuzugreifen erneut getter benutzen 
     */
    @Override
    public boolean ueberpruefen(Wurf wurf) {
        
        boolean eins =false;
        boolean zwei = false;
        boolean vier = false;
        
        for(int i =0; i<wurf.getAlleWuerfel().length; i++){
        	Wuerfel temp = wurf.getAlleWuerfel()[i];
        	if (temp.getAugenzahl()==1){
        		eins = true;
        	}
        	if(temp.getAugenzahl()==2){
        		zwei =true;
        	}
        	if(temp.getAugenzahl()==4){
        		vier=true;
        	}
        	
        }
        return eins&&zwei&&vier;
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