/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

/**
 *
 * @author janik
 */
public interface IKomunikaciaRozhovoru {

    public void vypisTextNpc(String dajTextNpc);

    public void vypisOdpovede(Iterable<Odpoved> dajOdpovede);

    public int dajCisloOdpovede(int pocitadlo);
}
