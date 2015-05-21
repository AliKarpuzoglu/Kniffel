package logic;

import GUI.*;
import java.util.*;

/**
 * 
 */
public class Spiel {

    /**
     * 
     */
    public Spiel() {
    }

    /**
     * 
     */
    private Spieler[] spieler;
    private GUI g = new GUI();




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
            
            this.spieler = new Spieler[mSpieler+cSpieler];
            
            for(int x = 0; x < mSpieler; x++){
                g.printmSpielerNamen();
                String name = in.next();
                this.spieler[x] = new MenschlicheSpieler(name);
            }
            
            for(int y = mSpieler; y < cSpieler; y++){
                this.spieler[y] = new ComputerSpieler("Computer"+(y-mSpieler+1));
            }
            
            wuerfelReihenfolgeAus();
            
            g.printReihenfolge(spieler);
            
        }
    }

    /**
     * 
     */
    public void wuerfelReihenfolgeAus() {
        int n = this.spieler.length;
        for (int i = 0; i < this.spieler.length; i++) {
            // Get a random index of the array past i.
            int random = i + (int) (Math.random() * (n - i));
            // Swap the random element with the present element.
            Spieler randomElement = this.spieler[random];
            this.spieler[random] = this.spieler[i];
            this.spieler[i] = randomElement;
        }
        
            
    }

    /**
     * 
     */
    public void spielen() {
       g.printWelcome();
       erstelleSpieler();
    }
    
    public static void main(String[] a){
        Spiel s = new Spiel();
        s.spielen();
    }

}