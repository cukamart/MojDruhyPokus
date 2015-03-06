/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.questy;

import janech.wof.predmety.Acko;
import janech.wof.predmety.IPredmet;
import janech.wof.prostredie.Miestnost;

public class QuestZiskajAcko extends Quest {

    public QuestZiskajAcko() {
    }

    public String dajZadanie() {
        return "Ziskaj A od ucitela v A12";
    }

    public void kontrolaHracZobralPredmet(IPredmet paPredmet) {
        if (paPredmet instanceof Acko) {
            skonci();
        }
    }

    @Override
    public void kontrolaHracPresielDoMiestnosti(Miestnost paMiestnost) {
        if (paMiestnost.dajNazov().equals("vratnica")) {
            if (!jeSkonceny()) {
                System.out.println("A teraz ziskaj acko!");
            }
        }
    }
}
