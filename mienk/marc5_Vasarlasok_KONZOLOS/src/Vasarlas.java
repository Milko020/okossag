import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Vasarlas {
    private LocalDate datum;
    private LocalTime idopont;
    private int ertek;
    private String aruhaz;

    public Vasarlas(String datumStr, String idopontStr, String ertekStr, String aruhaz) {
        this.datum = LocalDate.parse(datumStr);
        this.idopont = LocalTime.parse(idopontStr);
        this.ertek = Integer.parseInt(ertekStr);
        this.aruhaz = aruhaz;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public LocalTime getIdopont() {
        return idopont;
    }

    public int getErtek() {
        return ertek;
    }

    public String getAruhaz() {
        return aruhaz;
    }
}
