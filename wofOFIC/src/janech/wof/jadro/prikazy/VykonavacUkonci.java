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
class VykonavacUkonci implements IVykonavac {

    public VykonavacUkonci() {
    }

    @Override
    public boolean vykonaj(Hrac paHrac, String paParameter) {
        System.out.println("Ukonci, co?");
        return false;
    }

    @Override
    public boolean vykonaj(Hrac paHrac) {
        return true;
    }

    @Override
    public String dajPopis() {
        return "Ukonci hru";
    }
    
}
