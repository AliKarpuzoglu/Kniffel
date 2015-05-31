package logic;

import ergebnisse.Ergebnis;
import gui.*;

import java.util.*;

/**
 * 
 */
public class Spiel {
    private Spieler[] wuerfelReihenfolge;
    private int wuerfeltReihenfolge = 0;
    
    
    private Spieler[] spieler = new Spieler[6];
    private int pointer = 0;

    private int rundeSpiel = 1;

    private static Spiel instance = new Spiel();

    // Verhindere die Erzeugung des Objektes �ber andere Methoden
    private Spiel() {
    }

    public ArrayList<Ergebnis> moeglicheErgebnisse() {
        ArrayList<Ergebnis> moeglich = new ArrayList<>();
        for (Ergebnis e : this.spieler[pointer].ergebnisTabelle.getErgebnis()) {

            if (e.ueberpruefen(this.spieler[pointer].getWurf())) {
                  moeglich.add(e);
            }
      }
        return moeglich;
    }

    /**
     * wuerfelt fuer den aktuellen Spieler und gibt ein String-Array mit den Ergebnissen zurueck
     * @return Stringdarstellung des Ergebnisses
     */
    public String[] wuerfeln() {
        this.spieler[pointer].getWurf().wuerfeln();
        String[] temp = new String[5];
        for(int i =0; i< temp.length;i++){
            temp[i] = this.spieler[pointer].getWurf().getAlleWuerfel()[i].toString();
        }
        return temp;
    }

    public boolean erstelleSpieler(String[] namen) {
        this.pointer = namen.length;
        this.wuerfelReihenfolge = new Spieler[namen.length];
        for (int i = 0; i < namen.length; i++) {
            this.spieler[i] = new MenschlicheSpieler(namen[i]);
            this.wuerfelReihenfolge[i] = new MenschlicheSpieler(namen[i]);
        }
        if (namen.length > 6) {
            return false;
        } else {
            return true;
        }
    }

    public boolean erstelleCmSpieler(int i) {
        if(i==0){
            return true;
        }
        if ((pointer + i) > 6) {
            return false;
        }
        
        for (int n = pointer; n < i + pointer; n++) {
            spieler[n] = new ComputerSpieler();
        }
        
        pointer = pointer + i;

        Spieler[] temp = new Spieler[pointer];
        for (int m = 0; m < temp.length; m++) {
            temp[m] = spieler[m];
        }
        
        pointer = 0;
        this.spieler = temp;
        wuerfelReihenfolgeAus();
        return true;

    }
    
    public int[] weglegbareWuerfel(){
        int[] ret = new int[5];
        int counter = 0;
        Wuerfel[] temp = spieler[pointer].getWurf().getAlleWuerfel();
        for(int n = 0; n < temp.length; n++){
            if(!temp[n].isWeggelegt()){
                ret[counter] = temp[n].getAugenzahl();
                counter++;
            }
            
        }
        if(counter == 0){
            return null;
        }
        int[] ret2 = new int[counter];
        for(int i = 0; i<ret2.length;i++){
            ret2[i] = ret[i];
        }
        return ret2;
    }
    
    public String platzAuswuerfeln(){
        for(int i = 0; i < this.spieler.length; i++){
            if(this.wuerfelReihenfolge[this.wuerfeltReihenfolge].equals(this.spieler[i])){
                this.wuerfeltReihenfolge++;
                return ""+(i+1);
            }
        }
        return null;
    }

    public boolean wuerfelWeglegen(int i) {
        
            Wuerfel x = spieler[pointer].getWurf().getAlleWuerfel()[i];
            if(x.isWeggelegt()){
                return false;
            }else{
                x.beiseiteLegen();
                return true;
            }
        }
       
    

    public boolean ergebnisAnrechnen(Ergebnis x) {
        x.punkteAnrechnen(spieler[pointer].getWurf());
        return true;
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

    public Spieler[] getSpieler() {
        return spieler;
    }
    public int getRunde(){
        return this.rundeSpiel;
    }
    /**
     * fuehrt einen Computerzug des akutellen C-Spielers aus
     * @return gibt zurueck ob das eine valide Option war
     */
    public boolean computerSpielerZug(){
        if(spieler[this.pointer] instanceof ComputerSpieler){
            spieler[this.pointer].ergebnisAuswaehlen();
            zugBeenden();
            return true;
            
        }
        return false;
    }
    /**
     * Gibt an ob ein Mensch am Zug ist, ansonsten beendet diese Funktion den Zug des akutellen Computerspielers
     * @return Ist ein Mensch am Zug
     */
    public boolean menschAmZug(){
        if(this.spieler[this.pointer] instanceof MenschlicheSpieler){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Gibt den Namen des aktuellen Spielers zurück
     * @return Namen des aktiven Spielers
     */
    public String amZug(){
        return this.spieler[this.pointer].toString();
    }

    public static Spiel getInstance() {
        return instance;
    }

    public static void setInstance(Spiel instance) {
        Spiel.instance = instance;
    }

    public void zugBeenden() {
        if(pointer == spieler.length-1){
            pointer = 0;
        }else{
            pointer++;
        }
    }

}