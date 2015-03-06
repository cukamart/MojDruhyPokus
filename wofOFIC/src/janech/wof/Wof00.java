package janech.wof;

import janech.wof.jadro.Hra;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 *
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */
public class Wof00 {

    /**
     * @param args parametre programu
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Hra hra = new Hra(nacitajMapu());
        hra.hraj();
    }

    public static ArrayList<String> nacitajMapu() throws FileNotFoundException, IOException {
        ArrayList<String> paMapa = new ArrayList<String>();

        String cesta = "mapa11.txt";
        Scanner in = new Scanner(new File(cesta), "windows-1250");

        String riadok;

        while (in.hasNextLine()) {
            riadok = in.nextLine();
            if (!riadok.isEmpty()) {
                paMapa.add(riadok);
            }
        }
        in.close();

        return paMapa;
    }
}
