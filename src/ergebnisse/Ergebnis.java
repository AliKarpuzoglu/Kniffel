package ergebnisse;

import logic.Wuerfel;
import logic.Wurf;

/**
 * 
 */
public abstract class Ergebnis {
    
    protected int summe = 0;
    protected boolean oben;
    protected boolean gestrichen;

    public int getSumme() {
        return summe;
    }

    public boolean isOben() {
        return oben;
    }

    public boolean isGestrichen() {
        return gestrichen;
    }
    public void streiche(){
        this.gestrichen=true;
    }

    /**
     * @param wurf
     */
    public abstract boolean ueberpruefen(Wurf wurf);

    /**
     * @param wurf
     */
    public abstract int punkteBerechnen(Wurf wurf);

    public void punkteAnrechnen(Wurf wurf) {
        this.summe = punkteBerechnen(wurf);
    }

    public static int gleicheZahlen(Wurf wurf) {
        int gleicheZahlen = 1;
        Wuerfel[] temp = wurf.getAlleWuerfel();// CHECK IF THIS IS
                                               // OKAYY!!!!!!!!!!!!!!!!!!!
        for (int i = 1; i < temp.length; i++) {
            int momentan = 1;
            while (i < temp.length
                    && temp[i - 1].getAugenzahl() == temp[i].getAugenzahl()) {
                momentan++;
                i++;
            }
            if (gleicheZahlen < momentan) {
                gleicheZahlen = momentan;
            }
        }
        return gleicheZahlen;

    }

    public static int aufsteigendeZahlen(Wurf wurf) {
        int gleicheZahlen = 1;
        Wuerfel[] temp = wurf.getAlleWuerfel();// CHECK IF THIS IS
                                               // OKAYY!!!!!!!!!!!!!!!!!!!
        for (int i = 1; i < temp.length; i++) {
            int momentan = 1;
            while (i < temp.length) {
                if(temp[i - 1].getAugenzahl() + 1 == temp[i].getAugenzahl())
                momentan++;
                i++;
            }
            if(temp[i - 1].getAugenzahl() == temp[i].getAugenzahl()){
                i++;
            }
            if (gleicheZahlen < momentan) {
                gleicheZahlen = momentan;
            }
        }
        return gleicheZahlen;

    }

    @Override
    public String toString() {
        if(isGestrichen()){
            return "null";
        }
        return ""+ summe;
    }

    

}