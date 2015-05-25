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
    private int runde = 1;

    private static Spiel instance;

    // Verhindere die Erzeugung des Objektes �ber andere Methoden
    private Spiel() {
    }

    public static Spiel getInstance() {
        if (Spiel.instance == null) {
            Spiel.instance = new Spiel();
        }
        return Spiel.instance;
    }

    /**
     * 
     */
    public void erstelleSpieler() {
        boolean flag = true;
        while (flag) {
            Scanner in = new Scanner(System.in);

            g.printSpielerdialog();
            
            int mSpieler;
            try{
            mSpieler = in.nextInt();
            }catch(Exception e){
                mSpieler = 0;
            }
            if (mSpieler > 6) {
                break;
            }

            g.printComputerSpielerDialog(6 - mSpieler);
            int cSpieler;
            try{
            cSpieler = in.nextInt();
            }catch(Exception e){
                cSpieler = 0;
            }
            if ((mSpieler + cSpieler) > 6) {
                break;
            }

            this.spieler = new Spieler[mSpieler + cSpieler];

            for (int x = 0; x < mSpieler; x++) {
                g.printmSpielerNamen();
                String name = in.next();
                this.spieler[x] = new MenschlicheSpieler(name);
            }

            for (int y = mSpieler; y < cSpieler+mSpieler; y++) {
                this.spieler[y] = new ComputerSpieler();
            }

            wuerfelReihenfolgeAus();

            g.printReihenfolge(spieler);
            
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

    public static void main(String[] a) {
        Spiel s = new Spiel();
        s.spielen();
    }

    /**
     * 
     */
    public void spielen() {
        g.printWelcome();
        erstelleSpieler();
        for(int i = 0; i <13; i++){
            for(int y = 0; y < spieler.length; y++){
                spieler[y].getWurf().wuerfeln();
                g.printAmZugDialog(spieler,y);               
                spieler[y].ergebnisAuswaehlen();
               
            }
            runde ++;
        }
        System.out.println("Runde: "+ runde);
    }

    public Spieler[] getSpieler() {
        return spieler;
    }

}