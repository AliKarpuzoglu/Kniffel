package logic;

import java.util.*;

import ergebnisse.*;


/**
 * 
 */
public abstract class Spieler {
    
    public String name;
    public Wurf wurf;
    private ErgebnisTabelle ergebnisTabelle = new ErgebnisTabelle();
    

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
        wuerfel.beiseiteLegen();
    }




    @Override
    public String toString() {
        return "Spieler:" + name;
    }
    
    public ErgebnisTabelle getErgebnisTabelle(){
        return ergebnisTabelle;
    }
}