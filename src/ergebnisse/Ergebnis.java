package ergebnisse;

import logic.Wuerfel;
import logic.Wurf;

/**
 * 
 * @author Katharina, Ali, Fritz and Andr� 
 * 
 * 
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

    /**
     * Ueberprueft ob die Zahl gestrichen wurde
     */
    public void streiche() {
        this.gestrichen = true;
    }

    /**
     * @param wurf
     */
    public abstract boolean ueberpruefen(Wurf wurf);

    /**
     * @param wurf berechnet die moeglichen Punkte
     */
    public abstract int punkteBerechnen(Wurf wurf);

    public void punkteAnrechnen(Wurf wurf) {
        this.summe = punkteBerechnen(wurf);
    }

    /**
     * 
     * @param wurf
     * @return ueberprueft ob die gleiche Zahl nochmal vorhanden ist
     */
    public static int gleicheZahlen(Wurf wurf) {
        int gleicheZahlen = 1;
        Wuerfel[] temp = wurf.getAlleWuerfel();// CHECK IF THIS IS
                                               // OKAYY!!!!!!!!!!!!!!!!!!!

        int momentan = 1;
        int i = 1;
        while (i < temp.length && temp[i - 1].getAugenzahl() == temp[i].getAugenzahl()) {
            momentan++;
            i++;
        }
        if (gleicheZahlen < momentan) {
            gleicheZahlen = momentan;
        }


        return gleicheZahlen;

    }
    
    /**
     * 
     * @param wurf
     * @return gleicheZahlen, sortiert die Zahlen 
     */

    public static int aufsteigendeZahlen(Wurf wurf) {
        int gleicheZahlen = 1;
        Wuerfel[] temp = wurf.getAlleWuerfel();// CHECK IF THIS IS
                                               // OKAYY!!!!!!!!!!!!!!!!!!!
        // for (int i = 1; i < temp.length; i++) {
        int i = 1;
        int momentan = 1;
        while (i < temp.length) {
            if (temp[i - 1].getAugenzahl() + 1 == temp[i].getAugenzahl()) {
                momentan++;

            } else if (temp[i - 1].getAugenzahl() == temp[i].getAugenzahl()) {

            }
            if (gleicheZahlen < momentan) {
                gleicheZahlen = momentan;
            }
            i++;
        }
        // }
        return gleicheZahlen;

    }

    @Override
    public String toString() {
        if (isGestrichen()) {
            return "null";
        }
        return "" + summe;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (gestrichen ? 1231 : 1237);
        result = prime * result + (oben ? 1231 : 1237);
        result = prime * result + summe;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ergebnis other = (Ergebnis) obj;
        if (gestrichen != other.gestrichen)
            return false;
        if (oben != other.oben)
            return false;
        if (summe != other.summe)
            return false;
        return true;
    }
    public abstract String getName();

}