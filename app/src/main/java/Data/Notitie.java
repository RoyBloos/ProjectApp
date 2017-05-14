package Data;

import android.content.Context;

import com.orm.SugarRecord;

import java.util.Date;

public class Notitie extends SugarRecord {
    private String titel;
    private String tekst;
    private boolean favoriet;
    private Date aanmaakDatum;
    //private NotitieCategorie categorie;

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

    public boolean isFavoriet() {
        return favoriet;
    }

    public void setFavoriet(boolean favoriet) {
        favoriet = favoriet;
    }

    public Date getAanmaakDatum() {
        return aanmaakDatum;
    }

    public void setAanmaakDatum(Date aanmaakDatum) {
        aanmaakDatum = aanmaakDatum;
    }

    //public NotitieCategorie getCategorie() {
   //     return categorie;
   // }

   // public void setCategorie(NotitieCategorie categorie) {
  //      this.categorie = categorie;
   // }

    public Notitie(){
        super();
    }

    public Notitie(String titel, String tekst){
        this.titel = titel;
        this.tekst = tekst;
        this.favoriet = false;
        this.aanmaakDatum = new Date();
    }
}
