package logic;

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
       Arrays.sort(alleWuerfel);
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
        Arrays.sort(alleWuerfel);

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
    
    @Override
    public String toString(){
        String temp = "";
        for(int i = 0; i<alleWuerfel.length;i++){
            temp= temp + "Wuerfel "+ (i+1)+" : " + alleWuerfel[i].toString() + " | ";
        }
        return temp;
    }
}