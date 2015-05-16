package Logic;
import Logic.GameLogic.*;
public abstract class Player {
    
    private Dice[] dices = new Dice[5];
    private Dice[] side = new Dice[5];
    private String name;
    private int[] scoreboard;
}
