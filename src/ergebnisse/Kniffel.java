package ergebnisse;

import java.util.*;

import logic.Wurf;

/**
 * 
 */
public class Kniffel extends Ergebnis {

    /**
     * 
     */
    public Kniffel() {
    }

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        System.out.println("Kniffel"+((gleicheZahlen(wurf) == 5) &&(!gestrichen)&&(summe==0)));
        System.out.println(gleicheZahlen(wurf) == 5);
        System.out.println(!gestrichen);
        System.out.println(summe==0);
        return (gleicheZahlen(wurf) == 5) &&(!gestrichen)&&(summe==0);
        
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        if (ueberpruefen(wurf)) {
            return 50;
        } else {
            return 0;
        }    }

  

}