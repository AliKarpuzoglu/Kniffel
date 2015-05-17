package Logic;

import java.util.*;

/**
 * 
 */
public abstract class Spieler {

	public String name;
	public Wurf wurf;

	public Spieler(String name, Wurf wurf) {
		this.name = name;
		this.wurf = wurf;
	}

	/**
	 * @return
	 */
	public Wuerfel[] wuerfeln() {
		return wurf.wuerfeln();
	}

	/**
	 * @param wuerfel
	 */
	public void wuerfelWeglegen(Wuerfel wuerfel) {
		if (!wuerfel.isWeggelegt()) {
			wuerfel.beiseiteLegen();
		}

	}

}