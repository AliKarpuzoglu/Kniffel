package logic;

import java.util.*;

import ergebnisse.Ergebnis;
import ergebnisse.Ergebnis.ErgebnisName;


/**
 * 
 */
public class Wurf {
    private Wuerfel[] alleWuerfel = new Wuerfel[5];

    /**
     * 
     */
    public Wurf() {
       for(int i=0;i<5;i++){
           alleWuerfel[i]= new Wuerfel();
       }
       Arrays.sort(alleWuerfel);
    }

  

    /**
     * @return
     */
    public void wuerfeln() {
        for (Wuerfel w : alleWuerfel) {
            if (!w.isWeggelegt()) {
                w.wuerfeln();
            }
        }
        Arrays.sort(alleWuerfel);

    }
    /**
     * This one check which option the player have. There are 14 possibility...
     * @return rueckgabe
     * die letzte if Abfrage dient dazu alle Werte bzw die Null abzufangen.. 
     * Ebenfalls wird hier von Enum gebraucht gemacht
     */
    
    public ErgebnisName[] moeglicheErgebnisse(){
        ErgebnisName temp[] = new ErgebnisName[14];
        int zaehler = 0;
        if(checkDreierPasch()){
            temp[zaehler] = ErgebnisName.DREIERPASCH;
            zaehler++;
        }
        if(checkViererPasch()){
            temp[zaehler] = ErgebnisName.VIERERPASCH;
            zaehler++;
        }
        if(checkSechser()){
            temp[zaehler] = ErgebnisName.SECHSER;
            zaehler++;
            
        }
        if(checkKniffel()){
            temp[zaehler] = ErgebnisName.KNIFFEL;
            zaehler++;
        }
        if(checkEiner()){
            temp[zaehler] = ErgebnisName.EINER;
            zaehler++;
        }
        if(checkFuenfer()){
            temp[zaehler] = ErgebnisName.FUENFER;
            zaehler++;
        }
        if(checkFullhouse()){
            temp[zaehler] = ErgebnisName.FULLHOUSE;
            zaehler++;
        }
        if(checkGrosseStrasse()){
            temp[zaehler] = ErgebnisName.GROSSESTRASSE;
            zaehler++;
        }
        if(checkKleineStrasse()){
            temp[zaehler] = ErgebnisName.KLEINESTRASSE;
            zaehler++;
        }
        if(checkQuadratFolge()){
            temp[zaehler] = ErgebnisName.QUADRATFOLGE;
            zaehler++;
        }
        if(checkVierer()){
            temp[zaehler] = ErgebnisName.VIERER;
            zaehler++;
        }
        if(checkZweier()){
            temp[zaehler] = ErgebnisName.ZWEIER;
            zaehler++;
        }
        ErgebnisName rueckgabe[] = new ErgebnisName[zaehler];
        for(int i = 0; i< zaehler;i++){
            rueckgabe[i]=temp[i];
        }
        
        if(zaehler==0){
            rueckgabe = new ErgebnisName[1];
            rueckgabe[1] = ErgebnisName.NULLEN;
            
        }
        return rueckgabe;
    }
    
    /**
     * Hier wird �berpr�ft ob die gleichen Zahlen in einer Folge vorkommen
     * @return
     */
    public int gleicheZahlen() {
        int gleicheZahlen = 1;
        Wuerfel[] temp = this.getAlleWuerfel();// CHECK IF THIS IS
                                               // OKAYY!!!!!!!!!!!!!!!!!!!
        for (int i = 1; i < temp.length; i++) {
            int momentan = 1;
            while (i < temp.length && temp[i - 1].getAugenzahl() == temp[i].getAugenzahl()) {
                momentan++;
                i++;
            }
            if (gleicheZahlen < momentan) {
                gleicheZahlen = momentan;
            }
        }
        return gleicheZahlen;

    }
    
    public int aufsteigendeZahlen() {
        int gleicheZahlen = 1;
        Wuerfel[] temp = this.getAlleWuerfel();// CHECK IF THIS IS
                                               // OKAYY!!!!!!!!!!!!!!!!!!!
        for (int i = 1; i < temp.length; i++) {
            int momentan = 1;
            while (i < temp.length && temp[i - 1].getAugenzahl() + 1 == temp[i].getAugenzahl()) {
                momentan++;
                i++;
            }
            if (gleicheZahlen < momentan) {
                gleicheZahlen = momentan;
            }
        }
        return gleicheZahlen;

    }

    
    /**vielleicht awkward
     * 
     */
    public void wuerfelWeglegen(Wuerfel wuerfel) {
        wuerfel.beiseiteLegen();
    }

    public Wuerfel[] getAlleWuerfel() {
        return alleWuerfel;
    }
    @Override
    public String toString(){
        String temp = "";
        for(Wuerfel w: alleWuerfel){
            temp+=w.getAugenzahl();
        }
        return temp;
    }
    
    /**
     * Berechnung der Einzelnen im Enum stehenden M�glichkeiten..
     * @return
     */
    public boolean checkKleineStrasse(){
        return aufsteigendeZahlen() >= 4;
    }
    public boolean checkGrosseStrasse(){
        return aufsteigendeZahlen() == 5;
    }
    public boolean checkFullhouse(){
        Wuerfel[] temp = this.getAlleWuerfel();
        
        return gleicheZahlen() ==3&& ((
                equals(temp [1]) == 
                equals(temp [2]) && equals(temp[1]) == equals(temp[3]) &&
                equals(temp [4]) == equals (temp[5]) || ( equals(temp[1]) ==  
                equals(temp[2]) &&  equals(temp [1]) ==  equals(temp [3]) && 
                equals(temp[4])==  equals(temp[5]))));
    }
    
    public boolean checkKniffel(){
        return gleicheZahlen() == 5;
    }
    public boolean checkViererPasch(){
        return gleicheZahlen() >= 4;
    }
    public boolean checkDreierPasch(){
        return gleicheZahlen() >= 3;
    }
    public boolean checkAugen(int zahl){
    	 boolean temp = false;
         for(int i = 0; i < this.getAlleWuerfel().length;i++){
             if(this.getAlleWuerfel()[i].getAugenzahl()==zahl){
                 temp= true;
             }
         }
         return temp;
    }
    public boolean checkSechser(){
    /*    boolean temp = false;
        for(int i = 0; i < this.getAlleWuerfel().length;i++){
            if(this.getAlleWuerfel()[i].getAugenzahl()==6){
                temp= true;
            }
        }
        return temp;*/
    	return checkAugen(6);
    }
    public boolean checkFuenfer(){
       /* boolean temp = false;
        for(int i = 0; i < this.getAlleWuerfel().length;i++){
            if(this.getAlleWuerfel()[i].getAugenzahl()==5){
                temp= true;
            }
        }
        return temp;*/
    	return checkAugen(5);
    }
    public boolean checkVierer(){
       /* boolean temp = false;
        for(int i = 0; i < this.getAlleWuerfel().length;i++){
            if(this.getAlleWuerfel()[i].getAugenzahl()==4){
                temp= true;
            }
        }
        return temp;*/
    	return checkAugen(4);
    }
    public boolean checkDreier(){
        /*boolean temp = false;
        for(int i = 0; i < this.getAlleWuerfel().length;i++){
            if(this.getAlleWuerfel()[i].getAugenzahl()==3){
                temp= true;
            }
        }
        return temp;*/
    	return checkAugen(3);
    }
    public boolean checkZweier(){
        /*boolean temp = false;
        for(int i = 0; i < this.getAlleWuerfel().length;i++){
            if(this.getAlleWuerfel()[i].getAugenzahl()==2){
                temp= true;
            }
        }
        return temp;*/
    	return checkAugen(2);
    }
    public boolean checkEiner(){
       /* boolean temp = false;
        for(int i = 0; i < this.getAlleWuerfel().length;i++){
            if(this.getAlleWuerfel()[i].getAugenzahl()==1){
                temp= true;
            }
        }
        return temp;*/
    	return checkAugen(1);
    }
    public boolean checkQuadratFolge(){
       
    	return checkEiner() && checkZweier() && checkVierer();
    	
    	/*boolean eins = false;
        boolean zwei = false;
        boolean vier = false;

        for (int i = 0; i < this.getAlleWuerfel().length; i++) {
            Wuerfel temp = this.getAlleWuerfel()[i];
            if (temp.getAugenzahl() == 1) {
                eins = true;
            }
            if (temp.getAugenzahl() == 2) {
                zwei = true;
            }
            if (temp.getAugenzahl() == 4) {
                vier = true;
            }

        }
        return eins && zwei && vier;
        //return checkEiner()&&checkZweier()&&checkDreier();
        }*/
    

    }
    
    }