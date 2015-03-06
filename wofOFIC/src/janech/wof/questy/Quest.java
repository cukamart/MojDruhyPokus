/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.questy;

import janech.wof.predmety.Acko;
import janech.wof.predmety.IPredmet;
import janech.wof.prostredie.Miestnost;

/**
 *
 * @author janik
 */
public class Quest {

    private boolean aSkonceny;

    public Quest() {
        this.aSkonceny = false;
    }

    public String dajZadanie() {
        return null;
    }

    public boolean jeSkonceny() {
        return aSkonceny;
    }

    public void kontrolaHracZobralPredmet(IPredmet paPredmet) {

    }

    public void skonci() {
        aSkonceny = true;
        System.out.println("Vyriesil si quest");
    }

    public void kontrolaHracPresielDoMiestnosti(Miestnost paMiestnost) {
        
    }
}
