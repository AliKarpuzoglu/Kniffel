package logic;

import java.util.*;

import ergebnisse.Ergebnis;
import ergebnisse.ErgebnisTabelle;

public class ComputerSpieler extends Spieler {

    // private Wurf computerWurf;
    public static int playerCounter = 1;

    public ComputerSpieler() {
        super("Computer Spieler" + playerCounter++, new Wurf());

    }

    /**
     * 1. Finde noch ben�tigte 2. Finde bisher m�gliche 3. Schaue nach
     * Stra�e/Pasch 4. Schaue nach Quadratfolge 5. Schaue nach Punkten
     * m�glich oben-momentane, ob man noch gut bei 63 landen kann 6. W�hle
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
        // wenn nix m�glich ist, reroll die Hand
        // TODO: �berpr�fen wann beobachtet wird, dass 5 mal gew�rfelt wurde
        if (moeglich.size() == 0) {
            if (Spiel.runde == 5) {
                ergebnisAuswaehlenHelper();
                return;
            }
            wurf.wuerfeln();
            ergebnisAuswaehlen();
        }
        ergebnisAuswaehlenHelper();

    }

    private void kiErgebnisEintragen(Ergebnis e) {
        e.punkteAnrechnen(wurf);
    }

    /**
     * Last Step: In the end, choose the one with most value
     * 
     * @param wurf
     * @return
     */
    private void ergebnisAuswaehlenHelper() {
        int max = 0;
        Ergebnis beste = null;
        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
            if (e.ueberpruefen(wurf)) {
                if (e.punkteBerechnen(wurf) > max) {
                    max = e.punkteBerechnen(wurf);
                    beste = e;
                }
            }
        }
        if (beste == null) {
            // streiche ein ergebnis, fang von oben an und streiche das erste
            for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
                if (!e.isGestrichen() && e.getSumme() == 0) {
                    e.streiche();
                    return;
                }
            }
            ;
        }
        kiErgebnisEintragen(beste);
        // this.ergebnisTabelle.ergebnisEintragen(beste);
    }

}