
import java.util.*;

/**
 * 
 */
public class Wuerfel {

    /**
     * 
     */
    public Wuerfel() {
    }

    /**
     * 
     */
    private int augenzahl;

    /**
     * 
     */
    private boolean weggelegt;



    /**
     * @return
     */
    public int wuerfeln() {
        return (int) (Math.random() * 6) + 1;

    }

}