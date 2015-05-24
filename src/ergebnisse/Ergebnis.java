package ergebnisse;

import Logic.*;

/**
 * Benutzung von Enum. €nderung im Klassendiagramm muss noch dokumentiert
 * werden..
 * Somit ist es Ÿbersichtlicher und erspart "tausende" von KLassen bitch!
 */
   public enum Ergebnis {
        DREIERPASCH, FULLHOUSE, GROSSESTRASSE, KLEINESTRASSE,
        KNIFFEL, QUADRATFOLGE, VIERERPASCH, EINER, ZWEIER,
        DREIER, VIERER, FUENFER, SECHSER, NULLEN, BONUS;



    protected int summe;

    protected boolean gestrichen;


    private Ergebnis() {
        this.gestrichen = false;
    }

    public int getSumme() {
        return summe;
    }

    public boolean isGestrichen() {
        return gestrichen;
    }
    
    public int getSummeOben(){
        return EINER.summe+ZWEIER.summe+DREIER.summe+VIERER.summe+FUENFER.summe+SECHSER.summe;
    }

    private int punkteBerechnen(Wurf wurf, int wert) {
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

        switch (this) {
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
            case ZWEIER:
                if(!wurf.checkZweier()){
                    return 0;
                }
                return punkteBerechnen(wurf, 2);
               
            case DREIER:
                if(!wurf.checkDreier()){
                    return 0;
                }
                return punkteBerechnen(wurf, 3);
            case VIERER:
                if(!wurf.checkVierer()){
                    return 0;
                }
                return punkteBerechnen(wurf, 4);
            case FUENFER:
                if(!wurf.checkFuenfer()){
                    return 0;
                }
                return punkteBerechnen(wurf, 5);
            case SECHSER:
                if(!wurf.checkFuenfer()){
                    return punkteBerechnen(wurf,6);
                }
            case BONUS:
                if(getSummeOben()>=63){
                    return 35;
                }
                return 0;
                
               
                        


            default:
                return 0;


        }
    }

    public void punkteAnrechnen(Wurf wurf) {
        this.summe=this.punkteBerechnen(wurf);

    }


}