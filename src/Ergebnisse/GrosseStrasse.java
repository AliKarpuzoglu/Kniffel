package Ergebnisse;


import Logic.Wurf;


public class GrosseStrasse extends Ergebnis {

    /**
     * 
     */
    public GrosseStrasse() {
        super("Gro�e Stra�e", 25, false);
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