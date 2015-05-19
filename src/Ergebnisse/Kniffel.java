package Ergebnisse;

import java.util.*;

import Logic.Wuerfel;
import Logic.Wurf;

/**
 * 
 */
public class Kniffel{
    final static Wuerfel eins = new Wuerfel(1);
    final static Wuerfel zwei = new Wuerfel(2);
    
    public static void main(String[] a){
        Wuerfel würfel[] = {eins,eins,zwei};   
        for(int i=0; i< würfel.length;i++){
           System.out.println(würfel[i].toString());
        }
    }
}