package gui;

import logic.Spieler;

public interface GUI {
    
    public Spieler[] erstelleSpieler();
    
    public void wuerfelAuswaehlen(Spieler spieler);

}
