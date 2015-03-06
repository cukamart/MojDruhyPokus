/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.predmety;

import janech.wof.jadro.Hrac;


public class Acko implements IPredmet {

    @Override
    public String dajNazov() {
        return "A";
    }

    @Override
    public String pouzi(Hrac paHrac) {
        return "Ako chces pouzit Acko?";
    }
    
}
