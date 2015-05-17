package Ergebnisse;

import java.util.*;

import Logic.Wurf;

/**
 * 
 */
public class KleineStrasse extends Ergebnis {


    public KleineStrasse() {
        super("Groﬂe Straﬂe", 25, false);
    }

	@Override
	public boolean ueberpruefen(Wurf wurf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int punkteBerechnen(Wurf wurf) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void punkteAnrechnen(Wurf wurf) {
		// TODO Auto-generated method stub
		
	}
}