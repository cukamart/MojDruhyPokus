/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

import janech.wof.jadro.Hrac;

/**
 *
 * @author janik
 */
public interface IStavRozhovoru {

    String dajTextNpc();

    Iterable<Odpoved> dajOdpovede();

    IStavRozhovoru dajDalsiStav(int cislo);

    void vykonajAkciu(Hrac paHrac);
}
