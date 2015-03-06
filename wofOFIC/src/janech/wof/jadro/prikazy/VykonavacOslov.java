/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.jadro.prikazy;

import janech.wof.jadro.Hrac;
import janech.wof.npc.IKomunikaciaRozhovoru;
import janech.wof.npc.Odpoved;
import java.util.Scanner;

/**
 *
 * @author janik
 */
class VykonavacOslov implements IVykonavac, IKomunikaciaRozhovoru {

    @Override
    public boolean vykonaj(Hrac paHrac, String paParameter) {
        if (!paHrac.oslovNPC(paParameter, this)) {
            System.out.println("Nepodarilo sa!");
        }

        return false;
    }

    @Override
    public boolean vykonaj(Hrac paHrac) {
        System.out.println("Koho?");
        return false;
    }

    @Override
    public String dajPopis() {
        return "Oslovi zadane NPC.";
    }

    @Override
    public void vypisTextNpc(String paTextNpc) {
        System.out.println(paTextNpc);
    }

    @Override
    public void vypisOdpovede(Iterable<Odpoved> paOdpovede) {
        int pocitadlo = 1;
        for (Odpoved odpoved : paOdpovede) {
            System.out.format("%d) %s\n", pocitadlo, odpoved.dajTextOdpovede());
            pocitadlo++;
        }
    }

    @Override
    public int dajCisloOdpovede(int paPocet) {
        Scanner vstup = new Scanner(System.in);
        int cislo = 0;

        do {
            System.out.printf("Zadaj cislo (1-%d): ", paPocet);
            if (vstup.hasNextInt()) {
                cislo = vstup.nextInt();
            } else {
                vstup.nextLine();
            }
        } while (cislo < 1 || cislo > paPocet);

        return cislo;
    }
}
