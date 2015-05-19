package Logic;

import java.util.*;

import Ergebnisse.Ergebnis;

/**
 * 
 */
public class MenschlicheSpieler extends Spieler {

    /**
     * 
     */
    public MenschlicheSpieler() {
    	public MenschlieSpieler(String name, Wurf menschlicherwurf ){
    		super(name, menschlicherwurf  );
    		this.name = name;
    		this.wurf= menschlicherwurf;
    	}
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