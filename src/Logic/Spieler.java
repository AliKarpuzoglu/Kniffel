package Logic;

import java.util.*;

/**
 * 
 */
public abstract class Spieler {
    
	public String name;
	public Wurf wurf;

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