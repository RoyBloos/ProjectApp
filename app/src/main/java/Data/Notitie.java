package Data;

import com.orm.SugarRecord;

import java.util.Date;

public class Notitie extends SugarRecord {
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

    private boolean favoriet;

    public void setFavoriet(boolean favoriet) {
        this.favoriet = favoriet;
    }

    public boolean getFavoriet() {
        return favoriet;
    }

    private Date aanmaakdatum;

    public Date getAanmaakDatum() {
        return aanmaakdatum;
    }

    public void setAanmaakDatum(Date aanmaakdatum) {
        this.aanmaakdatum = aanmaakdatum;
    }

    public Notitie() {
        super();
    }

    public Notitie(String titel, String tekst) {
        setTitel(titel);
        setTekst(tekst);
        setAanmaakDatum(new Date());
    }
}
