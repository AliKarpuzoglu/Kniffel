package ergebnisse;

import java.util.*;

import logic.*;


/**
 * Benutzung von Enum. �nderung im Klassendiagramm muss noch dokumentiert werden.. 
 * Somit ist es �bersichtlicher und erspart "tausende" von KLassen bitch!
 */
public class Ergebnis {

    public enum ErgebnisName {
        DREIERPASCH, FULLHOUSE, GROSSESTRASSE, KLEINESTRASSE, 
        KNIFFEL, QUADRATFOLGE, VIERERPASCH, EINER, ZWEIER, 
        DREIER, VIERER, FUENFER, SECHSER, NULLEN;
        
        
    }

    private ErgebnisName name;

    protected int summe;

    protected boolean gestrichen;


    public Ergebnis(ErgebnisName name) {
        this.name = name;
    }

    public int getSumme() {
        return summe;
    }

    public boolean isGestrichen() {
        return gestrichen;
    }
    
        

    /**
     * @param wurf
     */
    public int punkteBerechnen(Wurf wurf) {
        int temp = 0;

        switch (this.name) {
        case DREIERPASCH:
            if(!wurf.checkDreierPasch()){
                return 0;
            }
            for (Wuerfel w : wurf.getAlleWuerfel()) {
                temp = w.getAugenzahl() + temp;
            }
            
            return temp;
        case VIERERPASCH:
            if(!wurf.checkViererPasch()){
                return 0;
            }
            for (Wuerfel w : wurf.getAlleWuerfel()) {
                temp = w.getAugenzahl() + temp;
            }
            return temp;
        
        
        case KNIFFEL:
        	if (!wurf.checkKniffel()){
        		return 0;
        	}
        	return 50;
        	
        case FULLHOUSE: 
        	if (!wurf.checkFullhouse()){
        		return 0;
        	}
        	return 25;
        	
        case KLEINESTRASSE:
        	if(!wurf.checkKleineStrasse()){
        		return 0;
        	}
        	return 30;
        	
        case GROSSESTRASSE:
        	if(!wurf.checkGrosseStrasse()){
        		return 0;
        	}
        	return 40;
        
        case QUADRATFOLGE:
        	if(!wurf.checkQuadratFolge()){
        		return 0;
        	}
        	return 15;
        case EINER:
        	if(!wurf.checkEiner()){
        		return 0;
        	}
        default: return 0;
                }
        	
        	
     /*
      * default:
            return 0;   		
      */
        	
        
    }
    
    public void punkteAnrechnen(Wurf wurf) {
    	

    }

   
    

}