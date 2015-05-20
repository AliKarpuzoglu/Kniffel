package Logic;

import java.util.*;

import Ergebnisse.Ergebnis;


public class MenschlicheSpieler extends Spieler {

	public String name;
	public Wurf menschlicherWurf;
    	
   public MenschlicheSpieler (String name, Wurf menschlicherWurf){

	   super(name, menschlicherWurf);
	   this.menschlicherWurf= menschlicherWurf;
    
    }

    /**
     * @param wurf 
     * @return
     */
    public Ergebnis ergebnisAuswaehlen(Wurf wurf) {
        // TODO implement here
        return null;
    }

}