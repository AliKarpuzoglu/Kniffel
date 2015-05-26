package logic;

import java.util.*;

import ergebnisse.*;
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
        if (runde == 5) {
            ergebnisAuswaehlenHelper();
            // ende:
            for (Wuerfel w : wurf.getAlleWuerfel()) {
                w.wiederReinholen();
            }
            runde = 1;

            return;
        }
        ArrayList<Ergebnis> moeglich = new ArrayList<>();

        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {

            if (e.ueberpruefen(wurf)) {
                moeglich.add(e);
            }
        }
        // wenn nix mï¿½glich ist, reroll die Hand

        if (moeglich.size() == 0) {
            if (runde < 5) {
                wurf.wuerfelWeglegen(wurf.getAlleWuerfel()[runde - 1]);
                wurf.wuerfeln();
                System.out.println(wurf);
                runde++;
                ergebnisAuswaehlen();
                return;
            }
        }
        // {
        if (Ergebnis.aufsteigendeZahlen(wurf) > 3) {
            if (runde < 5) {
                wurf.wuerfelWeglegen(wurf.getAlleWuerfel()[runde - 1]);
                wurf.wuerfeln();
                System.out.println(wurf);
                runde++;
                ergebnisAuswaehlen();
                return;
            }
        }
        if (Ergebnis.gleicheZahlen(wurf) > 2) {
            int maxGleich = meisteWuerfel(wurf);
            if (runde < 5) {
                // lege alle anderen würfel weg
                for (Wuerfel w : wurf.getAlleWuerfel()) {
                    if (w.getAugenzahl() == maxGleich) {
                        w.beiseiteLegen();
                    }

                }
                wurf.wuerfeln();
                System.out.println(wurf);
                runde++;
                ergebnisAuswaehlen();
                return;

            }
        }


        // wenn das mit den meisten Punkten eine Summe Oben ist:
        if (maxMoeglich(moeglich).isOben()) {

            if (runde < 5) {
                // lege alle anderen würfel weg
                for (Wuerfel w : wurf.getAlleWuerfel()) {
                    if (w.getAugenzahl() == ((SummeOben) maxMoeglich(moeglich))
                            .getWert()) {
                        w.beiseiteLegen();
                    }

                }
                wurf.wuerfeln();
                System.out.println(wurf);
                runde++;
                ergebnisAuswaehlen();
                return;

            }
            ergebnisAuswaehlenHelper();

            // ende:
            for (Wuerfel w : wurf.getAlleWuerfel()) {
                w.wiederReinholen();
            }
            runde = 1;
        }
    }

    /**
     * gebe die augenzahl zurück die am meisten vor kommt
     * 
     * @param w
     * @return
     */
    private int meisteWuerfel(Wurf w) {
        int count = 1, tempCount;
        int popular = w.getAlleWuerfel()[0].getAugenzahl();
        int temp = 0;
        for (int i = 0; i < (w.getAlleWuerfel().length - 1); i++) {
            temp = w.getAlleWuerfel()[i].getAugenzahl();
            tempCount = 0;
            for (int j = 1; j < w.getAlleWuerfel().length; j++) {
                if (temp == w.getAlleWuerfel()[j].getAugenzahl())
                    tempCount++;
            }
            if (tempCount > count) {
                popular = temp;
                count = tempCount;
            }
        }
        return popular;
    }

    /**
     * 
     * @param moeglich
     * @return true wenn das maximal moegliche mehr als 6 zurück gibt
     */
    private Ergebnis maxMoeglich(ArrayList<Ergebnis> moeglich) {

        Ergebnis beste = null;
        Ergebnis chance = null;
        int max = 0;
        for (Ergebnis e : moeglich) {
            if (e.ueberpruefen(wurf)) {
                // UND E KEINE CHANCE IST!
                if (e.punkteBerechnen(wurf) >= max && !(e instanceof Chance)) {
                    max = e.punkteBerechnen(wurf);
                    beste = e;
                }
                if (e instanceof Chance) {
                    chance = e;
                }
            }
        }
        if (beste == null && chance != null) {
            if (chance.ueberpruefen(wurf)) {
                beste = chance;
            }
        }
        return beste;
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
        Ergebnis chance = null;
        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
            if (e.ueberpruefen(wurf)) {
                if (e.punkteBerechnen(wurf) >= max && !(e instanceof Chance)) {
                    max = e.punkteBerechnen(wurf);
                    beste = e;
                }
                if (e instanceof Chance) {
                    chance = e;
                }
            }
        }
        // chance als letztes auswählen
        if (beste == null && chance != null) {
            if (chance.ueberpruefen(wurf)) {
                beste = chance;
            }
        }
        kiErgebnisEintragen(beste);
        // this.ergebnisTabelle.ergebnisEintragen(beste);

        // }
    }

}