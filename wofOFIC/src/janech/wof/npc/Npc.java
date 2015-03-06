/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.npc;

import janech.wof.jadro.Hrac;
import java.util.Scanner;

/**
 *
 * @author janik
 */
public class Npc {

    private final String aMeno;
    private final IStavRozhovoru aUvodnyStav;

    public Npc(String paMeno, IStavRozhovoru paUvodnyStav) {
        this.aMeno = paMeno;
        this.aUvodnyStav = paUvodnyStav;
    }

    public String dajMeno() {
        return aMeno;
    }

    public void oslov(Hrac paHrac, IKomunikaciaRozhovoru paKomunikacia) {
        Scanner vstup = new Scanner(System.in);
        
        IStavRozhovoru prst = aUvodnyStav;
        while (prst != null) {
            // oznamenie
            //System.out.println(prst.dajTextNpc());
            paKomunikacia.vypisTextNpc(prst.dajTextNpc());
            prst.vykonajAkciu(paHrac);
            if (prst.dajOdpovede() != null) {
                paKomunikacia.vypisOdpovede(prst.dajOdpovede());
                /*int pocitadlo = 1;
                for (Odpoved odpoved : prst.dajOdpovede()) {
                    System.out.printf("%d) %s\n", pocitadlo, odpoved.dajTextOdpovede());
                    pocitadlo++;
                }*/
                
                int pocitadlo = 0;
                for (Odpoved odpoved : prst.dajOdpovede()) {
                    pocitadlo++;
                }

                // vstup
                int cislo = paKomunikacia.dajCisloOdpovede(pocitadlo);
                /*int cislo = 0;
                do {
                    System.out.printf("Zadaj cislo (1-%d): ", pocitadlo - 1);
                    if (vstup.hasNextInt()) {
                        cislo = vstup.nextInt();
                    } else {
                        vstup.nextLine();
                    }
                } while (cislo <= 0 || cislo >= pocitadlo);*/

                // vykonanie
                prst = prst.dajDalsiStav(cislo);
            } else {
                prst = prst.dajDalsiStav(0);
            }
        }
    }
}
