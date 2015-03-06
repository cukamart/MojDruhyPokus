package janech.wof.prostredie;

import janech.wof.jadro.Hrac;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janik
 */
public class Dvere implements IDvere {

    private Miestnost aKamVedu;

    public Dvere(Miestnost paKamVedu) {
        this.aKamVedu = paKamVedu;
    }

    @Override
    public Miestnost dajKamVedu() {
        return aKamVedu;
    }
    
    @Override
    public boolean suPriechodne(Hrac paHrac) {
        return true;
    }
}
