/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

import janech.wof.jadro.Hrac;
import janech.wof.prostredie.Mapa;
import janech.wof.prostredie.Miestnost;
import java.util.ArrayList;

public class VyhladajCestu implements IStavRozhovoru {

    private final String aText;
    private ArrayList<Odpoved> aOdpovede;
    private final IStavRozhovoru aDalsiStav;
    private final Miestnost aZ;
    private final String aTextOdpoved;

    public VyhladajCestu(String paTextOtazka, String paTextOdpoved, Miestnost paZ, IStavRozhovoru paDalsiStav) {
        aOdpovede = null;
        this.aText = paTextOtazka;
        this.aDalsiStav = paDalsiStav;
        this.aZ = paZ;
        this.aTextOdpoved = paTextOdpoved;
    }

    @Override
    public String dajTextNpc() {
        return aText;
    }

    @Override
    public Iterable<Odpoved> dajOdpovede() {
        this.inicializujOdpovede();
        return aOdpovede;
    }

    @Override
    public IStavRozhovoru dajDalsiStav(int cislo) {
        this.inicializujOdpovede();
        return aOdpovede.get(cislo - 1).dajDalsiStav();
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
    }

    private void inicializujOdpovede() {
        if (aOdpovede == null) {
            aOdpovede = new ArrayList<>();
            
            for (Miestnost miestnost : Mapa.dajInstanciu().dajMiestnosti()) {
                aOdpovede.add(new Odpoved(miestnost.dajNazov(), new VyhladajCestuOdpoved(aTextOdpoved, aZ, miestnost, aDalsiStav)));
            }
        }
    }
}
