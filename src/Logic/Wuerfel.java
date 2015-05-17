package Logic;

import java.util.*;

/**
 * 
 */
public class Wuerfel implements Comparable<Wuerfel>{
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + augenzahl;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wuerfel other = (Wuerfel) obj;
		if (augenzahl != other.augenzahl)
			return false;
		return true;
	}



	private int augenzahl;
    private boolean weggelegt;
    /**
     * 
     */
    public Wuerfel() {
        weggelegt = false;
        augenzahl = (int) (Math.random() * 6) + 1;
    }



    /**
     * 
     */
    public void wuerfeln() {
        augenzahl= (int) (Math.random() * 6) + 1;

    }
    public boolean isWeggelegt(){
        return weggelegt;
    }
    
    public int getAugenzahl() {
        return augenzahl;
    }



    public void beiseiteLegen(){
        weggelegt = true;
    }



    @Override
    public int compareTo(Wuerfel o) {
        if(this.augenzahl>o.augenzahl){
            return 1;
        }else if (this.augenzahl<o.augenzahl){
            return -1;
        }
        return 0;
    }
    
   
}