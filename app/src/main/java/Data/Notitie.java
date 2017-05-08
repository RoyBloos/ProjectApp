package Data;

import android.content.Context;

import com.orm.SugarRecord;

public class Notitie extends SugarRecord {
    private String titel;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    private String tekst;

    public Notitie(){
        super();
    }

    public Notitie(String titel, String tekst){
        this.titel = titel;
        this.tekst = tekst;
    }
}
