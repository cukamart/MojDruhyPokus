package janech.wof.prostredie;

import janech.wof.npc.Npc;
import janech.wof.predmety.IPredmet;
import java.util.HashMap;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. Vychody z
 * miestnosti su oznacovane svetovymi stranami sever, vychod, juh a zapad. Pre
 * kazdy vychod si miestnost pamata odkaz na susednu miestnost alebo null, ak
 * tym smerom vychod nema.
 *
 * @author Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {

    private String aPopisMiestnosti;
    private HashMap<String, IDvere> aVychody;
    private final String aNazov;
    private HashMap<String, IPredmet> aPredmety;
    private HashMap<String, Npc> aNpc;

    /**
     * Vytvori miestnost popis ktorej je v parametrom. Po vytvoreni miestnost
     * nema ziadne vychody. Popis miesnost strucne charakterizuje.
     *
     * @param paPopis text popisu miestnosti.
     */
    public Miestnost(String paNazov, String paPopis) {
        this.aPopisMiestnosti = paPopis;
        aVychody = new HashMap<>();
        this.aNazov = paNazov;
        aPredmety = new HashMap<>();
        aNpc = new HashMap<>();
    }

    public String dajNazov() {
        return aNazov;
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom na
     * miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     *
     * @param paSever miestnost smerom na sever.
     * @param paVychod miestnost smerom na vychod.
     * @param paJuh miestnost smerom na juh.
     * @param paZapad miestnost smerom na zapad.
     */
    public void nastavVychod(Miestnost paMiestnost) {
        aVychody.put(paMiestnost.dajNazov(), new Dvere(paMiestnost));
    }

    void nastavVychod(IDvere paDvere) {
        aVychody.put(paDvere.dajKamVedu().dajNazov(), paDvere);
    }

    public void nastavVychody(Miestnost... paMiestnosti) {
        for (Miestnost miestnost : paMiestnosti) {
            if (miestnost != null) {
                aVychody.put(miestnost.dajNazov(), new Dvere(miestnost));
            }
        }
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String dajPopis() {
        return aPopisMiestnosti;
    }

    public String dajInfoMiestnosti() {
        String info = "Teraz si v miestnosti " + this.dajPopis()
                + "\nVychody: ";

        for (String smer : aVychody.keySet()) {
            info += smer + " ";
        }

        if (!aPredmety.isEmpty()) {
            info += "\nPredmety: ";

            for (String nazov : aPredmety.keySet()) {
                info += nazov + " ";
            }
        }

        if (!aNpc.isEmpty()) {
            info += "\nNPC: ";

            for (String nazov : aNpc.keySet()) {
                info += nazov + " ";
            }
        }

        return info + "\n";
    }

    public void vlozPredmet(IPredmet paPredmet) {
        aPredmety.put(paPredmet.dajNazov(), paPredmet);
    }

    public IPredmet vymazPredmet(String paNazov) {
        return aPredmety.remove(paNazov);
    }

    public IDvere dajDvereVSmere(String paSmer) {
        return aVychody.get(paSmer);
    }

    void postavNpc(Npc paNpc) {
        aNpc.put(paNpc.dajMeno(), paNpc);
    }

    public Npc dajNPC(String paMeno) {
        return aNpc.get(paMeno);
    }

    public boolean maVychodDo(Miestnost paMiestnost) {
        return aVychody.containsKey(paMiestnost.dajNazov());
    }
}
