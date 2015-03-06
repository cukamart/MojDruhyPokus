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
class VykonavacChod implements IVykonavac {

    @Override
    public boolean vykonaj(Hrac paHrac, String paParameter) {
        if (paHrac.chod(paParameter)) {
            System.out.println(paHrac.dajAktualnuMiestnost().dajInfoMiestnosti());
        } else {
            System.out.println("Tak to teda nie!");
        }

        return false;
    }

    @Override
    public boolean vykonaj(Hrac paHrac) {
        System.out.println("Chod kam?");
        return false;
    }

    @Override
    public String dajPopis() {
        return "Prejde do smeru so zadanym nazvom";
    }
}
