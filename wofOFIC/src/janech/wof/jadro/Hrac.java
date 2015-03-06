package janech.wof.jadro;

import janech.wof.npc.IKomunikaciaRozhovoru;
import janech.wof.npc.Npc;
import janech.wof.prostredie.Miestnost;
import janech.wof.prostredie.IDvere;
import janech.wof.prostredie.Mapa;
import janech.wof.prostredie.Mapa1;
import janech.wof.predmety.IPredmet;
import janech.wof.questy.Quest;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author janik
 */
public class Hrac {

    private Miestnost aAktualnaMiestnost;
    private HashMap<String, IPredmet> aInventar;
    private ArrayList<Quest> aQuesty;

    public Hrac(ArrayList<String> paMapa) {
        
        aAktualnaMiestnost = Mapa1.dajInstanciu(paMapa).dajZaciatocnuMiestnost();
        aInventar = new HashMap<>();
        aQuesty = new ArrayList<>();
    }

    public Miestnost dajAktualnuMiestnost() {
        return aAktualnaMiestnost;
    }

    public boolean chod(String paSmer) {
        //Miestnost miestnost = aAktualnaMiestnost.dajMiestnost(paSmer);
        IDvere dvere = aAktualnaMiestnost.dajDvereVSmere(paSmer);

        if (dvere != null && dvere.suPriechodne(this)) {
            aAktualnaMiestnost = dvere.dajKamVedu();

            for (Quest quest : aQuesty) {
                quest.kontrolaHracPresielDoMiestnosti(aAktualnaMiestnost);
            }

            return true;
        }

        return false;
    }

    public boolean zoberPredmet(String paNazov) {
        IPredmet predmet = aAktualnaMiestnost.vymazPredmet(paNazov);

        if (predmet != null) {
            //aInventar.put(paNazov, predmet);
            this.zoberPredmet(predmet);
            return true;
        }

        return false;
    }

    public void zoberPredmet(IPredmet paPredmet) {
        aInventar.put(paPredmet.dajNazov(), paPredmet);

        for (Quest quest : aQuesty) {
            quest.kontrolaHracZobralPredmet(paPredmet);
        }
    }

    public boolean zahodPredmet(String paNazov) {
        IPredmet predmet = aInventar.remove(paNazov);

        if (predmet != null) {
            aAktualnaMiestnost.vlozPredmet(predmet);
            return true;
        }

        return false;
    }

    public String dajBatoh() {
        String ret = "";
        for (String nazov : aInventar.keySet()) {
            ret += " " + nazov;
        }

        return ret;
    }

    public String pouziPredmet(String paNazov) {
        IPredmet predmet = aInventar.get(paNazov);

        if (predmet != null) {
            return predmet.pouzi(this);
        }

        throw new PredmetNenajdenyException();
    }

    public IPredmet dajPredmet(String paNazov) {
        return aInventar.get(paNazov);
    }

    public boolean oslovNPC(String paMeno, IKomunikaciaRozhovoru paKomunikacia) {
        Npc npc = aAktualnaMiestnost.dajNPC(paMeno);

        if (npc == null) {
            return false;
        }

        npc.oslov(this, paKomunikacia);

        return true;
    }

    public void pridajQuest(Quest paQuest) {
        aQuesty.add(paQuest);
    }

    public String dajPopisQuestov() {
        String ret = "";
        for (Quest quest : aQuesty) {
            ret += "\n" + quest.dajZadanie();
            if (quest.jeSkonceny()) {
                ret += "\nStav: skonceny";
            } else {
                ret += "\nStav: aktivny";
            }
        }

        return ret;
    }
}
