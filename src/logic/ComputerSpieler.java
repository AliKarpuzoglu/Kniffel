package logic;

import java.util.*;

import ergebnisse.Ergebnis;
import ergebnisse.ErgebnisTabelle;

public class ComputerSpieler extends Spieler {

//    private Wurf computerWurf;
    public static int playerCounter=1;
    public ComputerSpieler(String name, Wurf computerWurf) {
        super("Computer Spieler"+playerCounter++, computerWurf);

    }

    /**
     * 1. Finde noch benï¿½tigte 
     * 2. Finde bisher mï¿½gliche 
     * 3. Schaue nach
     * Straï¿½e/Pasch 
     * 4. Schaue nach Quadratfolge 
     * 5. Schaue nach Punkten mï¿½glich
     * oben-momentane, ob man noch gut bei 63 landen kann 
     * 6. Wï¿½hle das Ergebnis
     * mit meisten Punkten (statt Kniffel zuerst die oben)
     * 7. Streiche eventuell ein ergebnis
     * (Quadratfolge/Einer/Zweier...)
     * 
     */
    public void evaluate() {
        
        ArrayList<Ergebnis> benoetigt = new ArrayList<>();
        ArrayList<Ergebnis> moeglich = new ArrayList<>();
        
        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
            if(e.getSumme() == 0 && !e.isGestrichen()) {
                benoetigt.add(e);
            }
            if(e.ueberpruefen(wurf)){
                moeglich.add(e);
            }
        }
        //wenn nix möglich ist, reroll die Hand
        // TODO: überprüfen wann beobachtet wird, dass 5 mal gewürfelt wurde
        if(moeglich.size()==0){
        }
        if


    }
    
    
    public void kiErgebnisEintragen(Ergebnis e){
        e.punkteAnrechnen(wurf);
    }
    
    /**
     * Last Step: In the end, choose the one with most value
     * 
     * @param wurf
     * @return
     */
    public void optimiertesErgebnisAuswaehlen(Wurf wurf) {
        int max = 0;
        Ergebnis beste = null;;
        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
            if (e.ueberpruefen(wurf)) {
                if (e.punkteBerechnen(wurf) > max) {
                    max = e.punkteBerechnen(wurf);
                    beste = e;
                }
            }
        }
        if(beste==null){
            //streiche ein ergebnis, fang von oben an und streiche das erste
            for(Ergebnis e: ergebnisTabelle.getErgebnis()){
                if(!e.isGestrichen()){
                    e.streiche();
                    return;
                }
            };
        }
        kiErgebnisEintragen( beste);
//        this.ergebnisTabelle.ergebnisEintragen(beste);
    }

}