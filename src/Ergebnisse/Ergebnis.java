package Ergebnisse;

import java.util.*;

import Logic.*;

/**
 * Benutzung von Enum. €nderung im Klassendiagramm muss noch dokumentiert
 * werden..
 * Somit ist es Ÿbersichtlicher und erspart "tausende" von KLassen bitch!
 */
public class Ergebnis {

    public enum ErgebnisName {
        DREIERPASCH, FULLHOUSE, GROSSESTRASSE, KLEINESTRASSE,
        KNIFFEL, QUADRATFOLGE, VIERERPASCH, EINER, ZWEIER,
        DREIER, VIERER, FUENFER, SECHSER, NULLEN, BONUS;


    }

    private ErgebnisName name;

    protected int summe;

    protected boolean gestrichen;


    public Ergebnis(ErgebnisName name) {
        this.name = name;
        this.gestrichen = false;
    }

    public int getSumme() {
        return summe;
    }

    public boolean isGestrichen() {
        return gestrichen;
    }

    public int punkteBerechnen(Wurf wurf, int wert) {
        int zusammen = 0;
        for (Wuerfel w : wurf.getAlleWuerfel()) {
            if (w.getAugenzahl() == wert) {
                zusammen = zusammen + w.getAugenzahl();
            }
        }
        return zusammen;
    }


    /**
     * @param wurf
     */
    public int punkteBerechnen(Wurf wurf) {
        int temp = 0;

        switch (this.name) {
            case DREIERPASCH:
                if (!wurf.checkDreierPasch()) {
                    return 0;
                }
                for (Wuerfel w : wurf.getAlleWuerfel()) {
                    temp = w.getAugenzahl() + temp;
                }

                return temp;
            case VIERERPASCH:
                if (!wurf.checkViererPasch()) {
                    return 0;
                }
                for (Wuerfel w : wurf.getAlleWuerfel()) {
                    temp = w.getAugenzahl() + temp;
                }
                return temp;


            case KNIFFEL:
                if (!wurf.checkKniffel()) {
                    return 0;
                }
                return 50;

            case FULLHOUSE:
                if (!wurf.checkFullhouse()) {
                    return 0;
                }
                return 25;

            case KLEINESTRASSE:
                if (!wurf.checkKleineStrasse()) {
                    return 0;
                }
                return 30;

            case GROSSESTRASSE:
                if (!wurf.checkGrosseStrasse()) {
                    return 0;
                }
                return 40;

            case QUADRATFOLGE:
                if (!wurf.checkQuadratFolge()) {
                    return 0;
                }
                return 15;
            case EINER:
                if (!wurf.checkEiner()) {
                    return 0;
                }
                return punkteBerechnen(wurf,1);


            default:
                return 0;


        }
    }

    public void punkteAnrechnen(Wurf wurf) {


    }


}