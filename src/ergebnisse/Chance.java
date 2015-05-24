package ergebnisse;

import logic.Wuerfel;
import logic.Wurf;

public class Chance extends Ergebnis {

    @Override
    public boolean ueberpruefen(Wurf wurf) {
        return true;
    }

    @Override
    public int punkteBerechnen(Wurf wurf) {
        int temp = 0;
        for (Wuerfel w : wurf.getAlleWuerfel()) {
            temp = w.getAugenzahl() + temp;
        }
        return temp;
    }

}
