package Data;

import com.orm.SugarRecord;

import java.util.Date;

public class ToDo extends SugarRecord {
    private String titel;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    private String tekst;

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    private boolean gedaan;

    public boolean getGedaan() { return gedaan; }

    public void setGedaan(boolean gedaan) { this.gedaan = gedaan; }

    private Date aanmaakDatum;

    public Date getAanmaakDatum() {
        return aanmaakDatum;
    }

    public void setAanmaakDatum(Date aanmaakDatum) {
        this.aanmaakDatum = aanmaakDatum;
    }

    public ToDo() {
        super();
    }

    public ToDo(String titel, String tekst) {
        setTitel(titel);
        setTekst(tekst);
        setAanmaakDatum(new Date());
    }
}
