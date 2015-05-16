
import java.util.*;

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
    private String name;

    /**
     * 
     */
    private int summe;

    /**
     * 
     */
    private boolean oben;



    /**
     * @param wurf
     */
    public void ueberpruefen(Wurf wurf) {
        // TODO implement here
    }

    /**
     * @param wurf
     */
    public abstract void punkteBerechnen(Wurf wurf);

}