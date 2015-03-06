/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.jadro.prikazy;

import janech.wof.jadro.Hrac;
import janech.wof.jadro.PredmetNenajdenyException;

/**
 *
 * @author janik
 */
class VykonavacPouzi implements IVykonavac {

    @Override
    public boolean vykonaj(Hrac paHrac, String paParameter) {
        try {
            final String text = paHrac.pouziPredmet(paParameter);
            if (text != null) {
                System.out.println(text);
            }
        } catch (PredmetNenajdenyException e) {
            System.out.println("Nepodarilo sa!");
        }

        return false;
    }

    @Override
    public boolean vykonaj(Hrac paHrac) {
        System.out.println("Pouzi co?");
        return false;
    }

    @Override
    public String dajPopis() {
        return "Pouzije zadany predmet";
    }
}
