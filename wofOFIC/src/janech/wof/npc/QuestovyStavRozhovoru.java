/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

import janech.wof.jadro.Hrac;
import janech.wof.questy.Quest;

/**
 *
 * @author janik
 */
public class QuestovyStavRozhovoru implements IStavRozhovoru {
    private final String aText;
    private final Quest aQuest;
    private final IStavRozhovoru aDalsi;

    public QuestovyStavRozhovoru(String paText, Quest paQuest, IStavRozhovoru paDalsi) {
        this.aText = paText;
        this.aQuest = paQuest;
        this.aDalsi = paDalsi;
        
    }

    @Override
    public String dajTextNpc() {
        return aText;
    }

    @Override
    public Iterable<Odpoved> dajOdpovede() {
        return null;
    }

    @Override
    public IStavRozhovoru dajDalsiStav(int cislo) {
        return aDalsi;
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        paHrac.pridajQuest(aQuest);
    }
    
}
