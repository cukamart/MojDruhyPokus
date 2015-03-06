/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package janech.wof.jadro.prikazy;

import janech.wof.jadro.Hrac;

/**
 *
 * @author janik
 */
class VykonavacPomoc implements IVykonavac {

    private final ZoznamPrikazov aZoznamPrikazov;

    public VykonavacPomoc(ZoznamPrikazov paZoznamPrikazov) {
        aZoznamPrikazov = paZoznamPrikazov;
    }

    @Override
    public boolean vykonaj(Hrac paHrac, String paParameter) {
        IVykonavac vykonavac = aZoznamPrikazov.dajVykonavac(paParameter);
        if (vykonavac == null) {
            System.out.println("Nepoznam taky prikaz");
        } else {
            System.out.println(vykonavac.dajPopis());
        }
        return false;
    }

    @Override
    public boolean vykonaj(Hrac paHrac) {
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.print("   ");

        for (String nazov : aZoznamPrikazov.dajZoznamPrikazov()) {
            System.out.print(nazov + " ");
        }
        
        System.out.println();

        return false;
    }

    @Override
    public String dajPopis() {
        return "Zobrazi tuto napovedu";
    }
}
