package janech.wof.predmety;


import janech.wof.jadro.Hrac;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author janik
 */
public class Hodinky implements IPredmet {

    @Override
    public String dajNazov() {
        return "hodinky";
    }

    @Override
    public String pouzi(Hrac paHrac) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return "Hodinky ukazuju " + dateFormat.format(date);
    }
}
