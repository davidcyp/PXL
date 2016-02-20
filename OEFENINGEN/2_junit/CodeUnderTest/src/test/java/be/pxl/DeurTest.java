package be.pxl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeurTest {

    private Deur deur;

    @Before
    public void before(){
        deur = new Deur(); // zo vergewissen we ons er van dat de deur steeds gesloten is, aangezien dit de initiële status is
    }

    @Test
    public void openDeur(){
        assertFalse(deur.isOpen());
        deur.open();
        assertTrue(deur.isOpen());
    }

    @Test(expected = KanDeurNietBlokkerenException.class)
    public void kanDeurNietBlokkerenAlsIkHetPaswoordNietKen(){
        assertFalse(deur.isGeblokkeerd());
        deur.blokkeer("foute paswoord");
    }

    @Test
    public void kanDeurBlokkerenAlsIkHetPaswoordKen(){
        assertFalse(deur.isGeblokkeerd());
        deur.blokkeer("geheim");
        assertTrue(deur.isGeblokkeerd());
    }

}
