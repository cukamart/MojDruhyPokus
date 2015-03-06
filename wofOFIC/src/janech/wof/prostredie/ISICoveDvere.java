package janech.wof.prostredie;


import janech.wof.jadro.Hrac;
import janech.wof.predmety.ISIC;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class ISICoveDvere implements IDvere {
    private Miestnost aKamVedu;

    public ISICoveDvere(Miestnost paKamVedu) {
        this.aKamVedu = paKamVedu;
    }

    @Override
    public Miestnost dajKamVedu() {
        return aKamVedu;
    }

    @Override
    public boolean suPriechodne(Hrac paHrac) {
        ISIC isic = (ISIC) paHrac.dajPredmet("ISIC");
        
        return isic != null && isic.mozePrejst(paHrac.dajAktualnuMiestnost());
    }
    
}
