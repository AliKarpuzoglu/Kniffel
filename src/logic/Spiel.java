package logic;

import gui.*;

import java.util.*;

/**
 * 
 */
public class Spiel {

    /**
     * 
     */
   
    /**
     * 
     */
    private Spieler[] spieler;
    private GUI g = new GUI();
    public int runde = 1;

    private static Spiel instance;
    // Verhindere die Erzeugung des Objektes über andere Methoden
    private Spiel () {}

    public static Spiel getInstance () {
      if (Spiel.instance == null) {
        Spiel.instance = new Spiel ();
      }
      return Spiel.instance;
    }
  

    /**
     * 
     */
    public void erstelleSpieler() {
        boolean flag = true;
        while(flag){
            Scanner in = new Scanner(System.in);
            
            g.printSpielerdialog();
            int mSpieler = in.nextInt();
            
            if(mSpieler>6){
                break;
            }
            
            g.printComputerSpielerDialog(6-mSpieler);
            int cSpieler = in.nextInt();
            
            if((mSpieler+cSpieler)>6){
                break;
            }
            
            this.setSpieler(new Spieler[mSpieler+cSpieler]);
            
            for(int x = 0; x < mSpieler; x++){
                g.printmSpielerNamen();
                String name = in.next();
                this.getSpieler()[x] = new MenschlicheSpieler(name);
            }
            
            for(int y = mSpieler; y < cSpieler; y++){
                this.getSpieler()[y] = new ComputerSpieler("Computer"+(y-mSpieler+1));
            }
            
            wuerfelReihenfolgeAus();
            
            g.printReihenfolge(getSpieler());
            flag = false;
            
            
        }
    }

    /**
     * 
     */
    public void wuerfelReihenfolgeAus() {
        int n = this.getSpieler().length;
        for (int i = 0; i < this.getSpieler().length; i++) {
            // Get a random index of the array past i.
            int random = i + (int) (Math.random() * (n - i));
            // Swap the random element with the present element.
            Spieler randomElement = this.getSpieler()[random];
            this.getSpieler()[random] = this.getSpieler()[i];
            this.getSpieler()[i] = randomElement;
        }
        
            
    }

    /**
     * 
     */
    public void spielen() {
       g.printWelcome();
       erstelleSpieler();
    }
   

    public Spieler[] getSpieler() {
        return spieler;
    }


}