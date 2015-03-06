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
public interface IVykonavac {

    public boolean vykonaj(Hrac paHrac, String paParameter);

    public boolean vykonaj(Hrac paHrac);

    public String dajPopis();
}
