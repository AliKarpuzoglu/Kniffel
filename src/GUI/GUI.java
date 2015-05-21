package GUI;

import logic.Spieler;
import logic.Wurf;

/**
 * 
 */
public class GUI {

    public void printReihenfolge(Spieler[] spieler) {
        System.out.println("Die Reihenfolge der Spieler ist:");
        for(int i = 0; i< spieler.length; i++){
            System.out.println((i+1)+": "+spieler[i].toString());
        }
    }
    public void printmSpielerNamen(){
        System.out.printf("Bitte geben sie den Namen des nächsten Spielers ein");
    }
    public void printComputerSpielerDialog(int i){
        System.out.printf("Wie viele Computerspieler sollen teilnehmen?(0-%d)/n",i);
    }
    public void printSpielerdialog(){
        System.out.println("Es dürfen bis zu 6 Spieler teilnehmen");
        System.out.println("Bitte geben sie die Anzahl der menschlichen Spieler an(1-6)");
    }
    public void printWelcome(){
        System.out.println("Willkommen zu Kniffel");
        System.out.println("Die Gruppe um Jonas Jäkel wünscht ihnen ein erfreuliches Spiel");
    }
    public void printWurf(Wurf wurf) {
        System.out.println(wurf.toString());

    }

    /**
     * @param spieler
     */
    public void printErgebnisspalte(Spieler spieler) {
        // TODO implement here
    }
   

}