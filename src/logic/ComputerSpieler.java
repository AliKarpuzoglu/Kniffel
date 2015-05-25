package logic;

import java.util.*;

import ergebnisse.Ergebnis;
import ergebnisse.Ergebnis.*;

public class ComputerSpieler extends Spieler {

    // private Wurf computerWurf;
    public static int playerCounter = 1;

    public ComputerSpieler() {
        super("Computer Spieler" + playerCounter++, new Wurf());

    }

    /**
     * 1. Finde noch benï¿½tigte 2. Finde bisher mï¿½gliche 3. Schaue nach
     * Straï¿½e/Pasch 4. Schaue nach Quadratfolge 5. Schaue nach Punkten
     * mï¿½glich oben-momentane, ob man noch gut bei 63 landen kann 6. Wï¿½hle
     * das Ergebnis mit meisten Punkten (statt Kniffel zuerst die oben) 7.
     * Streiche eventuell ein ergebnis (Quadratfolge/Einer/Zweier...)
     * 
     */
    public void ergebnisAuswaehlen() {
        ArrayList<Ergebnis> moeglich = new ArrayList<>();

        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {

            if (e.ueberpruefen(wurf)) {
                moeglich.add(e);
            }
        }
        // wenn nix mï¿½glich ist, reroll die Hand
        
        if (moeglich.size() == 0) {
            if (runde == 5) {
                ergebnisAuswaehlenHelper();
                return;
            }
            if (runde < 5) {
                wurf.wuerfelWeglegen(wurf.getAlleWuerfel()[runde-1]);
                wurf.wuerfeln();
                System.out.println(wurf);
                runde++;
                ergebnisAuswaehlen();
                return;
            }
        }
        
        ergebnisAuswaehlenHelper();
        for(Wuerfel w: wurf.getAlleWuerfel()){
            w.wiederReinholen();
        }
        runde = 1;
    }
/**
 * 
 * @param moeglich
 * @return true wenn das maximal moegliche mehr als 6 zurück gibt
 */
    private boolean maxMoeglich(ArrayList<Ergebnis> moeglich) {

        Ergebnis beste = null;
        int max = 0;
        for (Ergebnis e : moeglich) {
            if (e.ueberpruefen(wurf)) {
                if (e.punkteBerechnen(wurf) >= max) {
                    max = e.punkteBerechnen(wurf);
                    beste = e;
                }
            }
        }
        if(max>6){
            return true;
        }
        return false;
    }

    private void kiErgebnisEintragen(Ergebnis e) {
        if (e == null) {
            kiStreicheErgebnis();
            return;
        }
       
        e.punkteAnrechnen(wurf);

    }

    private void kiStreicheErgebnis() {
        for (Ergebnis e : ergebnisTabelle.getErgebnis())
            if (!e.isGestrichen() && e.getSumme() == 0) {
                e.streiche();
                return;
            }
    }

    /**
     * Last Step: In the end, choose the one with most value
     * 
     * @param wurf
     * @return
     */
    private void ergebnisAuswaehlenHelper() {
        int max = -1;
        Ergebnis beste = null;
        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
            if (e.ueberpruefen(wurf)) {
                if (e.punkteBerechnen(wurf) >= max) {
                    max = e.punkteBerechnen(wurf);
                    beste = e;
                }
            }
        }
        // if (beste == null) {
        // // streiche ein ergebnis, fang von oben an und streiche das erste
        //
        // kiStreicheErgebnis();
        //
        // } else {

        kiErgebnisEintragen(beste);
        // this.ergebnisTabelle.ergebnisEintragen(beste);

        // }
    }

}