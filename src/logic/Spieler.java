package logic;

import java.util.*;

import ergebnisse.*;

/**
 * 
 */
public abstract class Spieler {
	public int runde = 1;
	public String name;
	public Wurf wurf;
	protected ErgebnisTabelle ergebnisTabelle = new ErgebnisTabelle();

	public Spieler(String name) {
		this.name = name;
		this.wurf = new Wurf();
	}

	/**
	 * @return
	 */
	public Wurf wuerfeln() {
		return wurf;
	}

	/**
	 * @param wuerfel
	 */
	public void wuerfelWeglegen(Wuerfel wuerfel) {
		wuerfel.beiseiteLegen();
	}

	public void wuerfelReinnehmen(Wuerfel wuerfel) {
		wuerfel.wiederReinholen();
	}

	public Wurf getWurf() {
		return this.wurf;
	}

	public abstract void ergebnisAuswaehlen();

	@Override
	public String toString() {
		return name;
	}

	public ErgebnisTabelle getErgebnisTabelle() {
		return ergebnisTabelle;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Spieler other = (Spieler) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

	
}