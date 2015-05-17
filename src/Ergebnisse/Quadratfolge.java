package Ergebnisse;



import Logic.Wurf;

/**
 * 
 */
public class Quadratfolge extends Ergebnis {

    /**
     * 
     */
    public Quadratfolge() {
    	super("Quadratfolge", 40, false);
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

	@Override
	public boolean ueberpruefen(Wurf[] wurf) {
		// TODO Auto-generated method stub
		return false;
	}

}