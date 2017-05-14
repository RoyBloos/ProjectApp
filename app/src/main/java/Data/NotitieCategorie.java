package Data;

import com.orm.SugarRecord;

public class NotitieCategorie extends SugarRecord {
    private String titel;
    private String beschrijving;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public NotitieCategorie(){
        super();
    }

    public NotitieCategorie(String titel, String beschrijving){
        this.titel = titel;
        this.beschrijving = beschrijving;
    }
}
