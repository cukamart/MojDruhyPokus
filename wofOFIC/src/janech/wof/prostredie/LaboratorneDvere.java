package janech.wof.prostredie;


import janech.wof.jadro.Hrac;
import janech.wof.jadro.SmrtException;
import janech.wof.predmety.Navleky;
import janech.wof.predmety.IPredmet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class LaboratorneDvere implements IDvere {

    private Miestnost aKamVedu;

    public LaboratorneDvere(Miestnost paKamVedu) {
        this.aKamVedu = paKamVedu;
    }

    @Override
    public Miestnost dajKamVedu() {
        return aKamVedu;
    }

    @Override
    public boolean suPriechodne(Hrac paHrac) {
        IPredmet navleky = paHrac.dajPredmet("navleky");
        if (navleky != null && ((Navleky)navleky).suObute())
            return true;
        throw new SmrtException("Stupil si do mlaky s kyselinou.");
    }
}
