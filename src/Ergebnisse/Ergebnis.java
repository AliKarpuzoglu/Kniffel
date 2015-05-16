
import java.util.*;

import Logic.Wurf;

/**
 * 
 */
public abstract abstract class Ergebnis {

    /**
     * 
     */
    public Ergebnis() {
    }

    /**
     * 
     */
    protected String name;

    /**
     * 
     */
    protected int summe;

    /**
     * 
     */
    protected boolean oben;



    /**
     * @param wurf
     */
    public abstract boolean ueberpruefen(Wurf wurf);
    

    /**
     * @param wurf
     */
    public abstract int punkteBerechnen(Wurf wurf);
    
    public abstract void punkteAnrechnen(Wurf wurf);


    
}