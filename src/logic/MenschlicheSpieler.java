package logic;

import java.util.*;

import ergebnisse.Ergebnis;



public class MenschlicheSpieler extends Spieler {

	
	
    	
   public MenschlicheSpieler (String name){

	   super(name, new Wurf());
	   
    
    }

    /**
     * @param wurf 
     * @return
     */
    public Ergebnis ergebnisAuswaehlen() {
        // TODO implement here
        return null;
    }

}