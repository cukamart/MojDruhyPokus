package janech.wof.prostredie;

import janech.wof.npc.QuestovyStavRozhovoru;
import janech.wof.npc.DavaciStavRozhovoru;
import janech.wof.npc.Npc;
import janech.wof.npc.StavRozhovoru;
import janech.wof.npc.VyhladajCestu;
import janech.wof.predmety.Acko;
import janech.wof.predmety.Hodinky;
import janech.wof.predmety.Navleky;
import janech.wof.predmety.ISIC;
import janech.wof.questy.Quest;
import janech.wof.questy.QuestZiskajAcko;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author janik
 */
public class Mapa1 {

    private static Mapa1 aInstancia;

    public static Mapa1 dajInstanciu(ArrayList<String> paMapa) {
        return aInstancia = new Mapa1(paMapa);
    }
    private final Miestnost aZaciatocnaMiestnost;
    private ArrayList<Miestnost> aMiestnosti;
    private String NacitavaSa;

    /**
     * Vytvori mapu hry - miestnosti.
     */
    private Mapa1(ArrayList<String> paMapa) {
        Miestnost paZaciatocnaMiestnost = new Miestnost("blabla", "blabla");
        aMiestnosti = new ArrayList<>();

        Scanner in;
        // nacitanie miestnosti
        for (String riadok : paMapa) {
            int poc = 0;
            in = new Scanner(riadok);
            String slovo = in.next();

            if (slovo.equals("Miestnost")) {
                aMiestnosti.add(new Miestnost(in.next(), in.nextLine()));
                registrujMiestnost(aMiestnosti.get(poc));
                poc++;
            }

        }

        // nacitanie startu
        for (String riadok : paMapa) {
            in = new Scanner(riadok);
            if (in.next().equals("Start")) {
                String slovo = in.next();
                for (Miestnost miestnost : aMiestnosti) {
                    if (slovo.equals(miestnost.dajNazov())) {
                        paZaciatocnaMiestnost = miestnost;
                    }
                }
            }

        }

        // nacitanie vychodov
        for (String riadok : paMapa) {
            int poc = 0;
            in = new Scanner(riadok);
            String slovo = in.next();

            if (slovo.equals("Miestnost")) {
                NacitavaSa = in.next();
            }

            //terasa.vlozPredmet(new ISIC());
            if (slovo.equals("ISIC")) {
                for (Miestnost miestnost : aMiestnosti) {
                    if (miestnost.dajNazov().equals(NacitavaSa)) {
                        miestnost.vlozPredmet(new ISIC());
                    }
                }
            }

            if (slovo.equals("Acko")) {
                for (Miestnost miestnost : aMiestnosti) {
                    if (miestnost.dajNazov().equals(NacitavaSa)) {
                        miestnost.vlozPredmet(new Acko());
                    }
                }
            }

            if (slovo.equals("Navleky")) {
                for (Miestnost miestnost : aMiestnosti) {
                    if (miestnost.dajNazov().equals(NacitavaSa)) {
                        miestnost.vlozPredmet(new Navleky());
                    }
                }
            }

            if (slovo.equals("Dvere") || slovo.equals("LaboratorneDvere") || slovo.equals("ISICoveDvere")) {
                //terasa.nastavVychody(vratnica);
                in.next();
                String vychod = in.next();
                for (Miestnost miestnost : aMiestnosti) {
                    if (miestnost.dajNazov().equals(NacitavaSa)) {
                        for (Miestnost vychodDoMiestnosti : aMiestnosti) {
                            if (vychodDoMiestnosti.dajNazov().equals(vychod)) {
                                if (slovo.equals("Dvere")) {
                                    miestnost.nastavVychod(vychodDoMiestnosti);
                                } else if (slovo.equals("LaboratorneDvere")) {
                                    miestnost.nastavVychod(new LaboratorneDvere(vychodDoMiestnosti));
                                } else if (slovo.equals("ISICoveDvere")) {
                                    miestnost.nastavVychod(new ISICoveDvere(vychodDoMiestnosti));
                                }
                            }
                        }
                    }
                }
            }
        }
        aZaciatocnaMiestnost = paZaciatocnaMiestnost;
        /*
         Miestnost terasa = new Miestnost("terasa", "Hlavný vstup na fakultu");
         registrujMiestnost(terasa);
         Miestnost vratnica = new Miestnost("vratnica", "Tu býva pani vrátnička");
         registrujMiestnost(vratnica);
         Miestnost ic = new Miestnost("ic", "ÍCéčko - informačné centrum");
         registrujMiestnost(ic);
         Miestnost a = new Miestnost("a", "Chodba v budove A");
         registrujMiestnost(a);
         Miestnost b = new Miestnost("b", "Chodba v budove B");
         registrujMiestnost(b);
         Miestnost wca = new Miestnost("wcA", "Nerád sem idem, ale keď musíš tak musíš");
         registrujMiestnost(wca);
         Miestnost wcb = new Miestnost("wcB", "Nerád sem idem, ale keď musíš tak musíš");
         registrujMiestnost(wcb);
         Miestnost a7 = new Miestnost("a7", "Učebňa");
         registrujMiestnost(a7);
         Miestnost a12 = new Miestnost("a12", "Počítačové laboratórium");
         registrujMiestnost(a12);
         Miestnost bufet = new Miestnost("bufet", "Čo máme dnes na obed?");
         registrujMiestnost(bufet);
         Miestnost b3 = new Miestnost("b3", "Počítačové laboratórium");
         registrujMiestnost(b3);

         terasa.nastavVychody(vratnica);
         vratnica.nastavVychody(terasa, a, b, ic);
         ic.nastavVychody(vratnica);
         a.nastavVychody(vratnica, wca, bufet, a7);
         a.nastavVychod(new LaboratorneDvere(a12));
         b.nastavVychody(vratnica, wcb);
         b.nastavVychod(new ISICoveDvere(b3));
         wca.nastavVychody(a);
         wcb.nastavVychody(b);
         a7.nastavVychody(a);
         a12.nastavVychody(a);
         bufet.nastavVychody(a);
         b3.nastavVychody(b); 

         //terasa.vlozPredmet(new Hodinky());
         terasa.vlozPredmet(new ISIC());

         bufet.vlozPredmet(new Navleky());

         vratnica.vlozPredmet(new Acko());

         StavRozhovoru vratnickaUvitanie = new StavRozhovoru("Vitaj na fakulte. "
         + "Dufam, ze si si ocistil topanky vonku");
         StavRozhovoru vratnickaKdeSom = new StavRozhovoru("A na co to chces vediet?");

         DavaciStavRozhovoru vratnickaDarujeHodinky = new DavaciStavRozhovoru(
         "Tu mas!", "Nemam!", new Hodinky(), vratnickaUvitanie);
        
         VyhladajCestu vratnickaPoznaCestu = new VyhladajCestu("A kam chces ist?", "Do miestnosti '%s' sa dostanes takto:", vratnica, vratnickaUvitanie);

         vratnickaUvitanie.pridajOdpoved("kde som?", vratnickaKdeSom);
         vratnickaUvitanie.pridajOdpoved("ako sa tam dostanem?", vratnickaPoznaCestu);
         vratnickaUvitanie.pridajOdpoved("daj hodinky", vratnickaDarujeHodinky);
         vratnickaUvitanie.pridajOdpoved("dovi", null);

         vratnickaKdeSom.pridajOdpoved("len tak", vratnickaUvitanie);
         vratnickaKdeSom.pridajOdpoved("dovi", null);


         vratnica.postavNpc(new Npc("vratnicka", vratnickaUvitanie));

         Quest ziskajAcko = new QuestZiskajAcko();

         QuestovyStavRozhovoru mamaDaQuest = new QuestovyStavRozhovoru(
         "Ziskaj A z informatiky!!!", ziskajAcko, null);

         terasa.postavNpc(new Npc("mama", mamaDaQuest));
         */

        // aZaciatocnaMiestnost = terasa;
    }

    public Miestnost dajZaciatocnuMiestnost() {
        return aZaciatocnaMiestnost;
    }

    private void registrujMiestnost(Miestnost paMiestnost) {
        aMiestnosti.add(paMiestnost);
    }

    public Miestnost dajMiestnost(String paNazov) {
        for (Miestnost miestnost : aMiestnosti) {
            if (miestnost.dajNazov().equals(paNazov)) {
                return miestnost;
            }
        }
        return null;
    }

    public Iterable<Miestnost> dajCestu(Miestnost paZ, Miestnost paDo) {
        final int pocet = aMiestnosti.size();
        final int nekonecno = pocet * 10;

        int[][] vzdialenosti = new int[pocet][pocet];
        int[][] dalsi = new int[pocet][pocet];

        for (int i = 0; i < pocet; i++) {
            for (int j = 0; j < pocet; j++) {
                if (i == j) {
                    vzdialenosti[i][j] = 0;
                    dalsi[i][j] = i;
                } else if (aMiestnosti.get(i).maVychodDo(aMiestnosti.get(j))) {
                    vzdialenosti[i][j] = 1;
                    dalsi[i][j] = i;
                } else {
                    vzdialenosti[i][j] = nekonecno;
                    dalsi[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < pocet; k++) {
            for (int i = 0; i < pocet; i++) {
                for (int j = 0; j < pocet; j++) {
                    final int staraVzdialenost = vzdialenosti[i][j];
                    final int novaVzdialenost = vzdialenosti[i][k] + vzdialenosti[k][j];

                    if (staraVzdialenost > novaVzdialenost) {
                        vzdialenosti[i][j] = novaVzdialenost;
                        dalsi[i][j] = dalsi[k][j];
                    }
                }
            }
        }

        int miestnostZ = aMiestnosti.indexOf(paZ);
        int miestnostDo = aMiestnosti.indexOf(paDo);
        int miestnostAct = miestnostDo;

        ArrayList<Miestnost> miestnosti = new ArrayList<>();

        while (miestnostAct != miestnostZ) {
            miestnosti.add(0, aMiestnosti.get(miestnostAct));
            miestnostAct = dalsi[miestnostZ][miestnostAct];
        }

        miestnosti.add(0, aMiestnosti.get(miestnostAct));

        return miestnosti;
    }

    public Iterable<Miestnost> dajMiestnosti() {
        return aMiestnosti;
    }
}
