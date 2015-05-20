package Logic;

import java.util.*;

import Ergebnisse.Ergebnis;
import Ergebnisse.Ergebnis.ErgebnisName;
import Ergebnisse.ErgebnisTabelle;
import Logic.Wurf;

public class ComputerSpieler extends Spieler {

//    private Wurf computerWurf;

    public ComputerSpieler(String name, Wurf computerWurf) {
        super("Computer Spieler", computerWurf);

    }
    
    // die ganze klasse muss noch geschrieben werden

    /**
     * 1. Finde noch ben�tigte 
     * 2. Finde bisher m�gliche 
     * 3. Schaue nach
     * Stra�e/Pasch 
     * 4. Schaue nach Quadratfolge 
     * 5. Schaue nach Punkten m�glich
     * oben-momentane, ob man noch gut bei 63 landen kann 
     * 6. W�hle das Ergebnis
     * mit meisten Punkten (statt Kniffel zuerst die oben)
     * 7. Streiche eventuell ein ergebnis
     * (Quadratfolge/Einer/Zweier...)
     * 
     */
    public void evaluate() {
    	Ergebnis ergebnis;
    	
    	
   
        
        ArrayList<Ergebnis> benoetigt = new ArrayList<>();
        ArrayList<Ergebnis> moeglich = new ArrayList<>();
        
        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
            if(e.getSumme() == 0 && !e.isGestrichen()) {
                benoetigt.add(e);
            }
            if(e.ueberpruefen(wurf)){
                moeglich.add(e);
            }
        }
        if(Ergebnis.aufsteigendeZahlen(wurf)>=Ergebnis.gleicheZahlen(wurf)){
           
        }
    }
    
    
    public void kiErgebnisEintragen(Ergebnis e){
        
    }
    /**
     * Last Step: In the end, choose the one with most value
     * 
     * @param wurf
     * @return
     */
    public Ergebnis optimiertesErgebnisAuswaehlen(Wurf wurf) {
        int max = 0;
        Ergebnis beste = null;;
        for (Ergebnis e : ergebnisTabelle.getErgebnis()) {
            if (e.ueberpruefen(wurf)) {
                if (e.punkteBerechnen(wurf) > max) {
                    max = e.punkteBerechnen(wurf);
                    beste = e;
                }
            }
        }
        if(beste==null){
            //streiche ein ergebnis
        }
        return beste;
//        this.ergebnisTabelle.ergebnisEintragen(beste);
    }

}