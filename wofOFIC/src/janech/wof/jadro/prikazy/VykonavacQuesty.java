/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.jadro.prikazy;

import janech.wof.jadro.Hrac;

/**
 *
 * @author janik
 */
class VykonavacQuesty implements IVykonavac {

    @Override
    public boolean vykonaj(Hrac paHrac, String paParameter) {
        System.out.println("Hmm?");
        return false;
    }

    @Override
    public boolean vykonaj(Hrac paHrac) {
        System.out.println(paHrac.dajPopisQuestov());
        
        return false;
    }

    @Override
    public String dajPopis() {
        return "Vypise zoznam questov";
    }
    
}
