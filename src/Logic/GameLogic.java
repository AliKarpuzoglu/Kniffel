package Logic;

public class GameLogic {
    public static final int NUMBER_OF_ROUNDS = 14; 
//    public static final int NUMBER_OF_DICE = 5;
    static int numberPlayers=0;
    static int humanPlayers=0;
    static Player[] players;
    
    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
       System.out.println("|Choose the amount of players (2-6) : \t|"   ); 
       //Input set numberPlayers
       System.out.println("|Human (2-"+ numberPlayers +") :\t\t\t\t|  " );
       //Input set humanPlayersx
       System.out.println("|Computer : " + (numberPlayers-humanPlayers) +"\t\t\t\t|") ;


    }

}
