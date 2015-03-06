package janech.wof.prostredie;

import janech.wof.jadro.Hrac;
import janech.wof.jadro.SmrtException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janik
 */
public interface IDvere {

    Miestnost dajKamVedu();

    boolean suPriechodne(Hrac paHrac);
}
