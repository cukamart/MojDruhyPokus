package janech.wof.jadro.prikazy;

import java.util.HashMap;

/**
 * Trieda NazvyPrikazov udrzuje zoznam nazvov platnych prikazov hry. Za ulohu ma
 * rozpoznavat platne prikazy.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class ZoznamPrikazov {
    // konstantne pole nazvov prikazov

    private HashMap<String, IVykonavac> aVykonavace;

    /**
     * Inicializuje zoznam platnych prikazov.
     */
    public ZoznamPrikazov() {
        aVykonavace = new HashMap<>();
        
        aVykonavace.put("pomoc", new VykonavacPomoc(this));
        aVykonavace.put("chod", new VykonavacChod());
        aVykonavace.put("ukonci", new VykonavacUkonci());
        aVykonavace.put("zober", new VykonavacZober());
        aVykonavace.put("zahod", new VykonavacZahod());
        aVykonavace.put("batoh", new VykonavacBatoh());
        aVykonavace.put("pouzi", new VykonavacPouzi());
        aVykonavace.put("oslov", new VykonavacOslov());
        aVykonavace.put("questy", new VykonavacQuesty());
    }

    /**
     * Kontroluje, ci nazov v parametri je platny prikaz.
     *
     * @return true ak je parameter platny prikaz, false inak.
     */
    public boolean jePrikaz(String paNazov) {
        return aVykonavace.containsKey(paNazov);
    }

    public Iterable<String> dajZoznamPrikazov() {
        return aVykonavace.keySet();
    }

    public IVykonavac dajVykonavac(String paNazovPrikazu) {
        return aVykonavace.get(paNazovPrikazu);
    }
}
