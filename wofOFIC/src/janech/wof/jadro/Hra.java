package janech.wof.jadro;

import janech.wof.jadro.prikazy.Prikaz;
import java.util.ArrayList;

/**
 * Trieda Hra je hlavna trieda aplikacie "World of FRI". "World of FRI" je velmi
 * jednoducha textova hra - adventura. Hrac sa moze prechadzat po niektorych
 * priestoroch - miestnostiach fakulty. To je v tejto verzii vsetko. Hru treba
 * skutocne zancne rozsirit, aby bola zaujimava.
 *
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy Hra (hra) a poslite
 * jej spravu hraj.
 *
 * Hra vytvori a inicializuje vsetky potebne objekty: vytvori vsetky miestnosti,
 * vytvori parser a zacne hru. Hra tiez vyhodnocuje a vykonava prikazy, ktore
 * vrati parser.
 *
 * @author Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Hra {

    private Parser aParser;
    private Hrac aHrac;

    /**
     * Vytvori a inicializuje hru.
     */
    public Hra(ArrayList<String> paMapa) {
        aParser = new Parser();
        aHrac = new Hrac(paMapa);
    }

    /**
     * Hlavna metoda hry. Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {
        vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.

        try {
            boolean jeKoniec = false;
            while (!jeKoniec) {
                Prikaz prikaz = aParser.dajPrikaz();
                jeKoniec = vykonajPrikaz(prikaz);
            }
        } catch (SmrtException e) {
            System.out.println(e.getMessage());
            System.out.println("Smola! Si mrtvy!");
        }
        System.out.println("Maj sa fajn!");
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println("Vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        String info = aHrac.dajAktualnuMiestnost().dajInfoMiestnosti();
        System.out.println(info);
    }

    /**
     * Prevezne prikaz a vykona ho.
     *
     * @param paPrikaz prikaz, ktory ma byt vykonany.
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    private boolean vykonajPrikaz(Prikaz paPrikaz) {
        if (paPrikaz.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }
        
        return paPrikaz.vykonaj(aHrac);
    }
}
