package gui;

import logic.Spiel;
import logic.Spieler;
import logic.Wurf;

public class GUI {

    public void printReihenfolge(Spieler[] spieler) {
        System.out.println("Die Reihenfolge der Spieler ist:");
        for (int i = 0; i < spieler.length; i++) {
            System.out.println((i + 1) + ": " + spieler[i].toString());
        }
    }

    public void printmSpielerNamen() {
        System.out.printf("Bitte geben sie den Namen des nächsten Spielers ein");
    }

    public void printComputerSpielerDialog(int i) {
        System.out.printf("Wie viele Computerspieler sollen teilnehmen?(0-%d)\n", i);
    }

    public void printSpielerdialog() {
        System.out.println("Es dürfen bis zu 6 Spieler teilnehmen");
        System.out.println("Bitte geben sie die Anzahl der menschlichen Spieler an(1-6)");
    }

    public void printWelcome() {
        System.out.println("Willkommen zu Kniffel");
        System.out.println("Die Gruppe um Jonas Jäkel wünscht ihnen ein erfreuliches Spiel");
    }

    public void printWurf(Wurf wurf) {
        System.out.println(wurf.toString());

    }

    /**
     * /**
     * 
     * @param spieler
     */
    public void printErgebnisspalte(Spieler[] spieler) {

        System.out.format("|%20s|%3s|%3s|%3s|%3s|%3s|%3s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n",
                "Spieler","1","2","3","4","5","6",
                "Summe","Bonus","Dreier","Vierer",
                "Quadrat","FullHouse", "Kleine",
                "Grosse","Kniffel",
                "Chance","Summe","Gesamt");
        for (int i = 0; i < spieler.length; i++)
            System.out
                    .format("|%20s|%3s|%3s|%3s|%3s|%3s|%3s|%10d|%10d|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10d|%10d|\n",
                            spieler[i].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[0].toString(),
                            spieler[i].getErgebnisTabelle().getErgebnis()[1].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[2].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[3].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[4].toString(),
                            spieler[i].getErgebnisTabelle().getErgebnis()[5].toString(),
                            spieler[i].getErgebnisTabelle().getSummeOben(),
                            spieler[i].getErgebnisTabelle().getBonus(),
                            spieler[i].getErgebnisTabelle().getErgebnis()[6].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[7].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[8].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[9].toString(),
                            spieler[i].getErgebnisTabelle().getErgebnis()[10].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[11].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[12].toString(), 
                            spieler[i].getErgebnisTabelle().getErgebnis()[13].toString(),
                            spieler[i].getErgebnisTabelle().getSummeUnten(),
                            spieler[i].getErgebnisTabelle().getGesamtSumme()
                            );

    }

    public void printAmZugDialog(Spieler[] spieler, int posi) {
        System.out.println("Am Zug ist : " + spieler[posi].toString());
        System.out.println("Ihr Zwischenergebnis:");
        printErgebnisspalte(spieler);
        System.out.println("Ihr Wurf:");
        System.out.println(spieler[posi].getWurf().toString());

    }

}