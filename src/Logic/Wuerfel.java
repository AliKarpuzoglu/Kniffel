package Logic;

import java.util.*;

/**
 * 
 */
public class Wuerfel {
    private int augenzahl;
    private boolean weggelegt;
    /**
     * 
     */
    public Wuerfel() {
        weggelegt = false;
        augenzahl = (int) (Math.random() * 6) + 1;
    }



    /**
     * 
     */
    public void wuerfeln() {
        augenzahl= (int) (Math.random() * 6) + 1;

    }
    public boolean isWeggelegt(){
        return weggelegt;
    }
    
    public int getAugenzahl() {
        return augenzahl;
    }



    public void beiseiteLegen(){
        weggelegt = true;
    }

}