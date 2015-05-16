package Logic;

import java.util.*;

/**
 * 
 */
public class Wurf {
    private Wuerfel[] alleWuerfel = new Wuerfel[5];

    /**
     * 
     */
    public Wurf() {
       for(int i=0;i<5;i++){
           alleWuerfel[i]= new Wuerfel();
       }
    }

  

    /**
     * @return
     */
    public void wuerfeln() {
        for (Wuerfel w : alleWuerfel) {
            if (!w.isWeggelegt()) {
                w.wuerfeln();
            }
        }
    }
    
    /**vielleicht awkward
     * 
     */
    public void wuerfelWeglegen(Wuerfel wuerfel) {
        wuerfel.beiseiteLegen();
    }

    public Wuerfel[] getAlleWuerfel() {
        return alleWuerfel;
    }

}