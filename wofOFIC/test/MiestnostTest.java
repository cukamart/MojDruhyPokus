/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import janech.wof.prostredie.IDvere;
import janech.wof.prostredie.Miestnost;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lubos
 */
public class MiestnostTest {
    
    public MiestnostTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of nastavVychody method, of class Miestnost.
     */
    @Test
    public void testNastavVychody() {
        System.out.println("nastavVychody");
        Miestnost paZapad = new Miestnost("bufet", "bufet");
        Miestnost instance = new Miestnost("terasa", "terasa");
        instance.nastavVychody(null, null, null, paZapad);
        Miestnost expResult = paZapad;
        Miestnost result = instance.dajDvereVSmere("bufet").dajKamVedu();
        assertEquals(expResult, result);
    }

    /**
     * Test of dajPopis method, of class Miestnost.
     */
    @Test
    public void testDajPopis() {
        System.out.println("dajPopis");
        Miestnost instance = new Miestnost("terasa", "terasa - hlavny vstup na fakultu");
        String expResult = "terasa - hlavny vstup na fakultu";
        String result = instance.dajPopis();
        assertEquals(expResult, result);
    }

    /**
     * Test of vypisInfoMiestnosti method, of class Miestnost.
     */
    @Test
    public void testDajInfoMiestnosti() {
        System.out.println("vypisInfoMiestnosti");
        Miestnost instance = new Miestnost("terasa", "terasa");
        String expResult = "Teraz si v miestnosti terasa\nVychody: \n";
        String result = instance.dajInfoMiestnosti();
        assertEquals(expResult, result);
    }

    /**
     * Test of dajMiestnost method, of class Miestnost.
     */
    @Test
    public void testDajMiestnost() {
        System.out.println("dajMiestnost");
        String smer = "bufet";
        Miestnost instance = new Miestnost("terasa", "terasa");
        IDvere result = instance.dajDvereVSmere(smer);
        assertNull(result);
    }
}