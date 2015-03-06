/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

import janech.wof.jadro.Hrac;
import janech.wof.predmety.Hodinky;
import janech.wof.predmety.IPredmet;

/**
 *
 * @author janik
 */
public class DavaciStavRozhovoru implements IStavRozhovoru {

    private final String aText;
    private IPredmet aPredmet;
    private final IStavRozhovoru aDalsi;
    private String aTextNema;

    public DavaciStavRozhovoru(String paText, String paTextNema, IPredmet paPredmet, IStavRozhovoru paDalsi) {
        this.aText = paText;
        this.aPredmet = paPredmet;
        this.aDalsi = paDalsi;
        aTextNema = paTextNema;
    }

    @Override
    public String dajTextNpc() {
        if (aPredmet == null) {
            return aTextNema;
        } else {
            return aText;
        }
    }

    @Override
    public Iterable<Odpoved> dajOdpovede() {
        return null;
    }

    @Override
    public IStavRozhovoru dajDalsiStav(int paCislo) {
        return aDalsi;
    }

    public void vykonajAkciu(Hrac paHrac) {
        if (aPredmet != null) {
            paHrac.zoberPredmet(aPredmet);
            aPredmet = null;
        }
    }
}
