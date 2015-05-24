package ergebnisse;

/**
 * 
 */
public class ErgebnisTabelle {

    /**
     * 
     */
    public ErgebnisTabelle() {
        for (int i = 1; i <= 6; i++) {
            ergebnisse[i - 1] = new SummeOben(i);
        }
        ergebnisse[6] = new Dreierpasch();
        ergebnisse[7] = new Viererpasch();
        ergebnisse[8] = new Quadratfolge();
        ergebnisse[9] = new Fullhouse();
        ergebnisse[10] = new KleineStrasse();
        ergebnisse[11] = new GrosseStrasse();
        ergebnisse[12] = new Kniffel();
        ergebnisse[13] = new Chance();
            

    }

    /**
     * 
     */
    private Ergebnis[] ergebnisse = new Ergebnis[14];

    /**
     * 
     */
    private final int BONUS = 35;

    /**
     * 
     */
    private int summeOben;

    /**
     * 
     */
    private int summeUnten;

    /**
     * 
     */
    private int summeGesamt;

    /**
     * toString()
     */
    public void tabelleAnzeigen() {
        // TODO implement here
    }
    
    /**
     * @return 
     * 
     */
    public String toString() {
        return null;
        // TODO implement here
    }


    /**
     * 
     */
    public int getGesamtSumme() {
//        int temp = 0;
//        for(Ergebnis e: ergebnisse){
//            temp+=e.getSumme();
//        }
//        if(getSummeOben()>=63){
//            temp+=BONUS;
//        }
//        return temp;
        int temp=getSummeOben()+getSummeUnten();
        return getSummeOben()>=63? temp : temp+BONUS;
    }

 
    /**
     * 
     */
    public void ergebnisEintragen(Ergebnis ergebnis) {
        for(Ergebnis e: ergebnisse){
            if(e.getClass().equals(ergebnis.getClass())){
                e=ergebnis;
            }
        }
    }

    /**
     * 
     */
    public int getSummeOben() {
        int temp=0;
        for(int i=0;i<6;i++){
            temp+=ergebnisse[i].getSumme();
        }
        return temp;
    }

    /**
     * 
     */
    public int getSummeUnten() {
        int temp=0;
        for(int i=6;i<ergebnisse.length;i++){
            temp+=ergebnisse[i].getSumme();
        }
        return temp;    }
    
    public Ergebnis[] getErgebnis(){
        return ergebnisse;
    }

}