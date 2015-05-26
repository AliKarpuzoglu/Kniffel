package logic;

import java.util.*;

import ergebnisse.*;


/**
 * 
 */
public abstract class Spieler {
    public int runde = 1;
    public String name;
    public Wurf wurf;
    protected ErgebnisTabelle ergebnisTabelle = new ErgebnisTabelle();
    

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
    public void wuerfelReinnehmen(Wuerfel wuerfel){
        wuerfel.wiederReinholen();
    }
    
    public Wurf getWurf(){
        return this.wurf;
    }


    public abstract void ergebnisAuswaehlenHelper1();


    @Override
    public String toString() {
        return   name;
    }
    
    public ErgebnisTabelle getErgebnisTabelle(){
        return ergebnisTabelle;
    }
}