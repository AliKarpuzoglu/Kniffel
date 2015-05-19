package Logic;

import java.util.*;

import Ergebnisse.*;
import Ergebnisse.Ergebnis.ErgebnisName;

/**
 * 
 */
public abstract class Spieler {
    
	public String name;
	public Wurf wurf;
	ErgebnisTabelle ergebnisTabelle;

    public Spieler(String name, Wurf wurf) {
    	this.name=name;
    	this.wurf=wurf;
    }
    
   

    
    /**
     * @return
     */
    public Wurf wuerfeln() {
		return wurf;
    }

    /**
     * @param wuerfel
     */
    public void wuerfelWeglegen(Wuerfel wuerfel) {
        // TODO implement here
    }

}