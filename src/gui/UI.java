package gui;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTable.PrintMode;

import ergebnisse.Ergebnis;
import logic.ComputerSpieler;
import logic.MenschlicheSpieler;
import logic.Spiel;
import logic.Spieler;
import logic.Wurf;
/**
 * Klasse zur Ausgabe des Spiel auf der Console
 * @author fritzbaumann
 * @param in Scanner des Consolen-UI
 * @param spiel Spiel-Instanz des UI
 * 
 */
public class UI{
    
    private Scanner in = new Scanner(System.in);
    
    private Spiel spiel= Spiel.getInstance();
    
    public static void main(String[] a){
        UI gui = new UI();
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
        gui.clear();
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
                gui.spiel.zugBeenden();
                gui.uIwait();
                gui.clear();
                
            }else{
                //Computerzug
                    if(!gui.spiel.computerSpielerZug()){
                        gui.somethingWentTerriblyWrong();
                    }
                    gui.uIwait();
                    gui.clear();
            }
        }
        
        gui.endergebnis();
        //schließe den Scanner
        gui.in.close();
    }
    public void clear(){
        System.out.printf("\n\n\n\n\n\n\n\n");
    }
    public void uIwait(){
        System.out.println("Taetige eine Eingabe um fortzufahren");
        in.next();
    }
    public void endergebnis(){
        System.out.println("Das Endergebnis: ");
        printErgebnisspalte(spiel.getSpieler());
    } 
    public boolean auswaehlenDialog() {
        System.out.println("Moechten sie ein Ergebnis eintragen oder Wuerfel weglegen (1/2)");
        int wahl = 0;
        try{
            wahl = in.nextInt();
        }catch(Exception e){
            in.next();
            return true;
        }
        if(!((wahl==1)||(wahl==2))){
            return true;
        }
        if(wahl ==1 ){
            return ergebnisAuswaehlenDialog();
        }else{
            return wuerfelWeglegenDialog();
        }
       
    }
    private boolean wuerfelWeglegenDialog() {
        boolean flagg = true;
        do{
        System.out.printf("Geben sie den wegzulegenden Wuerfel  an\n");        
        if(spiel.weglegbareWuerfel()==null){
            System.out.println("Keine weglegbare Wuerfel mehr");  
            return true;
        }else{
            System.out.println("Noch wegzulegende Wuerfel:");
            for(int i = 0; i< spiel.weglegbareWuerfel().length;i++){
                System.out.println(spiel.weglegbareWuerfel()[i]);
            }
        }
        try{
            if(!spiel.wuerfelWeglegen(in.nextInt()-1)){
                System.out.println("Ungueltiger Wuerfel");
                break;
            }
        }catch(Exception e){
            in.next();
            break;
        }
        
        System.out.println("Moechten sie noch einen Wuerfel weglegen(Ja = 1, Nein = 0)");
        int wahl = -1;
        try{
            wahl = in.nextInt();
        }catch(Exception e){
            in.next();
            break;
        }
        if(wahl==0){
            if(spiel.getGewuerfelt()>=5){
                System.out.println("Kann nicht erneut gewuerfelt werden. Bitte Ergebnis auswaehlen.");
                flagg = false;
            }else{
            wuerfeln();
            flagg = false;}
        }
        }while(flagg);
        return true;
    }
    private boolean ergebnisAuswaehlenDialog() {
        boolean flagg = true;
        int choice = 0;
        while(flagg){
            System.out.println("Moechten sie ein moegliches Ergebnis eintragen oder ein Ergebnis streichen (1, 2)");
            try{
                choice = in.nextInt();
            }catch(Exception e){
                in.next();
                continue;
            }
            if((choice==1)||(choice==2)){
                flagg = false;
            }
        }
        int moeglichkeiten;
        if(choice == 1){
             moeglichkeiten = moeglicheErgebnisse();
        }else{
            if(choice!=2){
                
            }
             moeglichkeiten = alleEintragbarenErgebnisse();
        }
        System.out.println("Gib die Zahl entsprechend dem anzurechnenden Ergebnis an");
        int wahl = 0;
        try{
            wahl = in.nextInt();
        }catch(Exception e){
            in.next();
            return true;
        }
        if(choice == 1){
        if(!(wahl==0)&&(wahl<(moeglichkeiten+1))){
            spiel.ergebnisAnrechnen(spiel.moeglicheErgebnisse().get(wahl-1));
            spiel.wuerfeln();
            return false;
        }else{
            return true;
        }}else{
            if(!(wahl==0)&&(wahl<(moeglichkeiten+1))){
                spiel.ergebnisAnrechnen(spiel.eintragbareErgebnisse().get(wahl-1));
                spiel.wuerfeln();
                return false;
            }else{
                return true;
            }
        }
        
    }
    private int alleEintragbarenErgebnisse() {
        System.out.println("Alle eintragbaren Ergebnisse");
        ArrayList<Ergebnis> moeglich = spiel.eintragbareErgebnisse();
        for(int s = 0; s< moeglich.size();s++){
            System.out.println(moeglich.get(s).getName()+" : "+(s+1));
        }
        return moeglich.size();
    }
    public int moeglicheErgebnisse() {
        System.out.println("Moegliche Ergebnisse:");
        ArrayList<Ergebnis> moeglich = spiel.moeglicheErgebnisse();
        for(int s = 0; s< moeglich.size();s++){
            System.out.println(moeglich.get(s).getName()+" : "+(s+1));
        }
        return moeglich.size();
        
    }
    public void wuerfeln(){
        System.out.println("Taetige eine Eingabe um zu wuerfeln");
        in.next();
        String[] wuerfel = spiel.wuerfeln();
        for(int i = 0; i< wuerfel.length;i++){
            System.out.printf("Wuerfel %d: %s\n",(i+1) ,wuerfel[i]);
        }
    }
    
    public void amZug(){
        System.out.printf("Am Zug ist: %s \n", spiel.amZug());
    }
    public void wuerfeln(String i){
        System.out.println(i+": Bitte taetige eine Eingabe um deinen Platz auszuwürfeln");
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
        boolean flagg = true;
        while(flagg){
            System.out.printf("Wie viele Computerspieler sollen teilnehmen?(0-%d)\n", i);
            try{
                ret = in.nextInt();
            }catch(Exception e){
                in.next();
                break;
            }
        
            if(ret>i){
                ret =  0;
                break;
            }
            
            flagg = false;
            
        }
        return ret;
    }

    public int printSpielerdialog() {
        System.out.println("Es dürfen bis zu 6 Spieler teilnehmen");
        
     
        int temp = 0;
        boolean flagg=true;
        while(flagg){     
            System.out.println("Bitte geben sie die Anzahl der menschlichen Spieler an(1-6)");
            try{
                int input = in.nextInt();
                temp = input;
                if(!((temp>6)||(temp<=0))){
                    flagg = false;
                    return temp;
                }
            }catch(Exception e){
                in.next();
                continue;
            }
            
            
        }
        return temp;
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