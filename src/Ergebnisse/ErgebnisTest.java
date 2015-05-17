package Ergebnisse;

import static org.junit.Assert.*;

import org.junit.Test;

import Logic.Wuerfel;
import Logic.Wurf;

public class ErgebnisTest {

    @Test
    public void testErgebnis() {
        fail("Not yet implemented");
    }

    @Test
    public void testUeberpruefen() {
        fail("Not yet implemented");
    }

    @Test
    public void testPunkteBerechnen() {
        fail("Not yet implemented");
    }

    @Test
    public void testPunkteAnrechnen() {
        fail("Not yet implemented");
    }

    @Test
    public void testGleicheZahlen() {
    	Wuerfel [] wuerfel = new Wuerfel[5];
        Wurf test1 = new Wurf(wuerfel);

        System.out.println(test1);
        assertEquals(3, Ergebnis.gleicheZahlen(test1));
    }

    @Test
    public void testAufsteigendeZahlen() {
    	Wuerfel [] wuerfel = new Wuerfel[5];
        Wurf test1 = new Wurf(wuerfel);

        System.out.println(test1);
        assertEquals(3, Ergebnis.aufsteigendeZahlen(test1));
    }

}
