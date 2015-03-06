/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

import janech.wof.jadro.Hrac;
import janech.wof.prostredie.Mapa;
import janech.wof.prostredie.Miestnost;

/**
 *
 * @author janik
 */
class VyhladajCestuOdpoved implements IStavRozhovoru {
    private final String aText;
    private final Miestnost aZ;
    private final Miestnost aDo;
    private final IStavRozhovoru aDalsiStav;

    public VyhladajCestuOdpoved(String paText, Miestnost paZ, Miestnost paDo, IStavRozhovoru paDalsiStav) {
        this.aText = paText;
        this.aZ = paZ;
        this.aDo = paDo;
        this.aDalsiStav = paDalsiStav;
    }

    @Override
    public String dajTextNpc() {
        StringBuilder ret = new StringBuilder(String.format(aText, this.aDo.dajNazov()));
        ret.append('\n');
        
        for (Miestnost miestnost : Mapa.dajInstanciu().dajCestu(aZ, aDo)) {
            ret.append("- ");
            ret.append(miestnost.dajNazov());
            ret.append('\n');
        }
        
        return ret.toString();
    }

    @Override
    public Iterable<Odpoved> dajOdpovede() {
        return null;
    }

    @Override
    public IStavRozhovoru dajDalsiStav(int cislo) {
        return aDalsiStav;
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        
    }
    
}
