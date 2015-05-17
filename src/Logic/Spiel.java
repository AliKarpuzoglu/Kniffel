package Logic;


public class Spiel {
	

	private Spieler[] spieler;

    public Spiel() {
    }


    public void erstelleSpieler() {
    	System.out.println("Wieviele Spieler möchten spielen?");
    	//einlesen + Menschliche Spieler erstellen
    	MenschlicheSpieler Spieler1 = new MenschlicheSpieler("Tobias", spielerWurf);
    	
    	System.out.println("Wieviele Computer Spieler sollen noch hinzugefügt werden?");
    	//einlesen
    	System.out.println("");
        
    }

    public void wuerfelReihenfolgeAus() {

    }

  
    public void spielen() {
    }

}