package janech.wof.predmety;

import janech.wof.jadro.Hrac;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janik
 */
public class Navleky implements IPredmet {

    private boolean aSuObute;
    private int aPocetPouziti;
    private final int MAX_POCET_POUZITI = 2;

    public Navleky() {
        aSuObute = false;
        aPocetPouziti = 0;
    }

    public String dajNazov() {
        return "navleky";
    }

    public String pouzi(Hrac paHrac) {
        if (aSuObute) {
            aSuObute = false;
            return "Vyzul si si navleky";
        } else if (aPocetPouziti < MAX_POCET_POUZITI) {
            aPocetPouziti++;
            aSuObute = true;
            return "Obul si si navleky";
        } else {
            return "Navleky su absolutne znicene";
        }
    }

    public boolean suObute() {
        return aSuObute;
    }
}
