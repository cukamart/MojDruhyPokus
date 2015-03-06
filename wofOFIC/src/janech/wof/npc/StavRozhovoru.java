/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

import janech.wof.jadro.Hrac;
import java.util.ArrayList;

/**
 *
 * @author janik
 */
public class StavRozhovoru implements IStavRozhovoru {
    private final String aTextNpc;
    private final ArrayList<Odpoved> aOdpovede;

    public StavRozhovoru(String paTextNPC) {
        this.aTextNpc = paTextNPC;
        aOdpovede = new ArrayList<>();
    }

    public void pridajOdpoved(String paTextOdpovede, IStavRozhovoru paDalsiStav) {
        aOdpovede.add(new Odpoved(paTextOdpovede, paDalsiStav));
    }

    public String dajTextNpc() {
        return aTextNpc;
    }

    public Iterable<Odpoved> dajOdpovede() {
        return aOdpovede;
    }

    public IStavRozhovoru dajDalsiStav(int paCislo) {
        return aOdpovede.get(paCislo - 1).dajDalsiStav();
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        
    }
}
