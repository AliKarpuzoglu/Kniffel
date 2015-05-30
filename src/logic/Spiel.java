package logic;

import gui.*;

import java.util.*;

/**
 * 
 */
public class Spiel {

    private Spieler[] spieler = new Spieler[6];
    private int pointer;
    
    private int rundeSpiel = 1;

    private static Spiel instance = new Spiel();

    // Verhindere die Erzeugung des Objektes �ber andere Methoden
    private Spiel() {
    }
    
    public String[] moeglicheErgebnisse(){
        return null;
    }
    
    public String[] wuerfeln(){
        return null;
    }

   public void erstelleSpieler(String[] namen){
       pointer = namen.length;
       for(int i = 0; i < namen.length; i++){
           spieler[i] = new MenschlicheSpieler(namen[i]);
       }
   }
   public void erstelleCmSpieler(int i){
       for(int n = pointer; n < i+pointer;n++){
           spieler[n] = new ComputerSpieler();
       }
       pointer =+ i;
       if(pointer<6){
           Spieler[] temp = new Spieler[pointer];
           for(int m = 0; m< temp.length; m++){
               temp[m] = spieler[m];
           }
           this.spieler = temp;
       }
   }
   public boolean wuerfelWeglegen(int[] i){
       return false;
   }
   public boolean ergebnisAnrechnen(Ergebnisse x){
       return false;
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

    
   

    public Spieler[] getSpieler() {
        return spieler;
    }

    public static Spiel getInstance() {
        return instance;
    }

    public static void setInstance(Spiel instance) {
        Spiel.instance = instance;
    }

}