package gui;

import java.util.Scanner;

import javax.swing.JTable.PrintMode;

import logic.ComputerSpieler;
import logic.MenschlicheSpieler;
import logic.Spiel;
import logic.Spieler;
import logic.Wurf;

public class GUI_Terminal{
    
    private Scanner in = new Scanner(System.in);
    
    private Spiel spiel= Spiel.getInstance();
    
    public static void main(String[] a){
        GUI_Terminal gui = new GUI_Terminal();
        gui.printWelcome();
        //erstelle menschliche Spieler
        int mSpieler = gui.printSpielerdialog();
        String[] namen = gui.printmSpielerNamen(mSpieler);
        if(!gui.spiel.erstelleSpieler(namen)){
            gui.somethingWentTerriblyWrong();
        }
        //erstelle Computerspieler
        int anzahlc = gui.printComputerSpielerDialog(6-namen.length);
        if(!gui.spiel.erstelleCmSpieler(anzahlc)){
            gui.somethingWentTerriblyWrong();
        }
        //Reihenfolge auswuerfeln
        for(int i = 0; i < namen.length;i++){
            gui.wuerfeln(namen[i]);
            String platz = gui.spiel.platzAuswuerfeln();
            System.out.printf("Du bist der %s -te Spieler \n",platz);
        }
        //Spielzuege
        while(gui.spiel.getRunde()<15){
            gui.amZug();
            gui.printErgebnisspalte(gui.spiel.getSpieler());
            //menschlicher Spielzug
            if(gui.spiel.menschAmZug()){
                //initialwuerfeln
                gui.wuerfeln();
                boolean zug = true;
                while(zug){
                    gui.moeglicheErgebnisse();
                    zug = gui.auswaehlenDialog();
                }
                
            }else{
                //Computerzug
                    if(!gui.spiel.computerSpielerZug()){
                        gui.somethingWentTerriblyWrong();
                    }
            }
        }
        
        gui.endergebnis();
        //schließe den Scanner
        gui.in.close();
    }
    public void endergebnis(){
        System.out.println("Das Endergebnis: ");
        printErgebnisspalte(spiel.getSpieler());
    } 
    public boolean auswaehlenDialog() {
        // TODO Auto-generated method stub
        return false;
    }
    public void moeglicheErgebnisse() {
        System.out.println("Moegliche Ergebnisse:");
        header();
        System.out.format("|%20s|%4s|%4s|%4s|%4s|%4s|%4s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n",spiel.moeglicheErgebnisse());
        
    }
    public void wuerfeln(){
        System.out.println("Druecken sie Eingabe um zu wuerfeln");
        in.nextLine();
        String[] wuerfel = spiel.wuerfeln();
        for(int i = 0; i< wuerfel.length;i++){
            System.out.printf("Wuerfel %d: %s\n",i,wuerfel[1]);
        }
    }
    
    public void amZug(){
        System.out.printf("Am Zug ist: %s", spiel.amZug());
    }
    public void wuerfeln(String i){
        System.out.println(i+": Bitte gib etwas ein und druecke Eingabe um deinen Platz auszuwürfeln");
        in.next();
    }
    public void somethingWentTerriblyWrong(){
        System.out.println("Something went terribly wrong, pls restart the game");
    }


    public String[] printmSpielerNamen(int i) {
        String[] namen = new String[i];
        for(int o = 0; o<i; o++){
            System.out.printf("Bitte geben sie den Namen des naechsten Spielers ein \n");
            String temp = in.next();
            namen[o] = temp;
        }
        
        return namen;
    }

    public int printComputerSpielerDialog(int i) {
        
        int ret = 0;
        while(ret == 0){
            System.out.printf("Wie viele Computerspieler sollen teilnehmen?(0-%d)\n", i);
            try{
                ret = in.nextInt();
            }catch(Exception e){}
        
            if(ret>i){
                ret =  0;
            }
        }
        return ret;
    }

    public int printSpielerdialog() {
        System.out.println("Es dürfen bis zu 6 Spieler teilnehmen");
        System.out.println("Bitte geben sie die Anzahl der menschlichen Spieler an(1-6)");
        int temp = 0;
        int input = 0;
        while(temp == 0){     
            try{
                input = in.nextInt();
            }catch(Exception e){
                break;
            }
            if(input>6){
                break;
            }else{
                temp = input;
            }
            
        }
        return input;
    }

    public void printWelcome() {
        System.out.println("Willkommen zu Kniffel");
        System.out.println("Die Gruppe um Jonas Jaekel wünscht ihnen ein erfreuliches Spiel");
    }

    public void printWurf(Wurf wurf) {
        System.out.println(wurf.toString());

    }
    public void header(){
        System.out.format("|%20s|%4s|%4s|%4s|%4s|%4s|%4s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|\n",
                "Spieler","1","2","3","4","5","6",
                "Summe","Bonus","Dreier","Vierer",
                "Quadrat","FullHouse", "Kleine",
                "Grosse","Kniffel",
                "Chance","Summe","Gesamt");
    }

    /**
     * /**
     * 
     * @param spieler
     */
    public void printErgebnisspalte(Spieler[] spieler) {
        header();     
        for (int i = 0; i < spieler.length; i++)
            System.out
                    .format("|%20s|%4s|%4s|%4s|%4s|%4s|%4s|%10d|%10d|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10s|%10d|%10d|\n",
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

    

    
    

   

}