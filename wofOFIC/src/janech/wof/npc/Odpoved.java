/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

/**
 *
 * @author janik
 */
public class Odpoved {

    private final String aTextOdpovede;
    private final IStavRozhovoru aDalsiStav;

    Odpoved(String paTextOdpovede, IStavRozhovoru paDalsiStav) {
        this.aTextOdpovede = paTextOdpovede;
        this.aDalsiStav = paDalsiStav;
    }

    public String dajTextOdpovede() {
        return aTextOdpovede;
    }

    public IStavRozhovoru dajDalsiStav() {
        return aDalsiStav;
    }
}
