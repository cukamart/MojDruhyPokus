package janech.wof.predmety;

import janech.wof.jadro.Hrac;
import janech.wof.prostredie.Miestnost;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class ISIC implements IPredmet {
    private Miestnost aPouzityV;

    public ISIC() {
        aPouzityV = null;
    }

    @Override
    public String dajNazov() {
        return "ISIC";
    }

    @Override
    public String pouzi(Hrac paHrac) {
        aPouzityV = paHrac.dajAktualnuMiestnost();
        
        return null;
    }

    public boolean mozePrejst(Miestnost paZMiestnosti) {
        Miestnost pouzity = aPouzityV;
        aPouzityV = null;
        return pouzity == paZMiestnosti;
    }
    
    
}
