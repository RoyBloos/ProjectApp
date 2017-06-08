package Data;

import com.orm.SugarRecord;

import java.util.Date;

public class ToDo extends SugarRecord {
    private String titel;
    private String tekst;
    private boolean favoriet;
    private Date aanmaakDatum;
    private ToDoCategorie categorie;

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

    public ToDoCategorie getCategorie() {
        return categorie;
    }

    public void setCategorie(ToDoCategorie categorie) {
        this.categorie = categorie;
    }

    public ToDo(){
        super();
    }

    public ToDo(String titel, String tekst){
        this.titel = titel;
        this.tekst = tekst;
        this.favoriet = false;
        this.aanmaakDatum = new Date();
    }
}
