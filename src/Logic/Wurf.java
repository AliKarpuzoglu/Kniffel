package Logic;

import java.util.*;

import Ergebnisse.Ergebnis;
import Ergebnisse.Ergebnis.ErgebnisName;

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
    
    public ErgebnisName[] moeglicheErgebnisse(){
        ErgebnisName temp[] = new ErgebnisName[14];
        int zaehler = 0;
        if(gleicheZahlen()>=3){
            temp[zaehler] = ErgebnisName.DREIERPASCH;
            zaehler++;
        }
        if(gleicheZahlen()>=4){
            temp[zaehler] = ErgebnisName.VIERERPASCH;
            zaehler++;
        }
        if(checkSechser()){
            temp[zaehler] = ErgebnisName.SECHSER;
            zaehler++;
            
        }
    }
    
    
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
    
    public boolean checkSechser(){
        boolean temp = false;
        for(int i = 0; i < this.getAlleWuerfel().length;i++){
            if(this.getAlleWuerfel()[i].getAugenzahl()==6){
                temp= true;
            }
        }
        return temp;
    }
}