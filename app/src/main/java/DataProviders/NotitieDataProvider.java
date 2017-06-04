package DataProviders;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Data.Notitie;
import Data.NotitieCategorie;

public class NotitieDataProvider {

    private NotitieDataProvider(){}

    private static NotitieDataProvider provider;

    public static NotitieDataProvider getProvider(){
        if(provider == null){
            provider = new NotitieDataProvider();
        }
        return provider;
    }

    public ArrayList<Notitie> GeefAlleNotities()
    {
        List<Notitie> x =  Select.from(Notitie.class)
                .orderBy("")
                .list();



        ArrayList<Notitie> alleNotities = new ArrayList<>();
        Iterator<Notitie> notitieIterator = Data.Notitie.findAll(Notitie.class);

        while (notitieIterator.hasNext()) {
            alleNotities.add(notitieIterator.next());
        }
        Collections.reverse(alleNotities);
        return alleNotities;
    }

    public boolean OpslaanNotitie(String titel, String notitie, NotitieCategorie notitieCategorie)
    {
        try{
            if(titel != null && notitie != null) {
                Notitie newNotitie = new Notitie(titel, notitie);
                newNotitie.setCategorie(notitieCategorie);
                newNotitie.save();
                return true;
            }
        } catch (Exception ex){
            Exception p = ex;
        }
        return false;
    }

    public void OpslaanNotitieCategorie(String titel, String beschrijving){

        NotitieCategorie newCategorie = new NotitieCategorie();
        newCategorie.setTitel(titel);
        newCategorie.setBeschrijving(beschrijving);
        newCategorie.save();
    }

    public NotitieCategorie GeefNotitieCategorieOpTitel(String titel){
        return Select.from(NotitieCategorie.class)
                     .where(Condition.prop("titel").eq(titel))
                     .first();
    }

    public Notitie GeefNotitieOpId(Long notitieId){
        return Select.from(Notitie.class)
                     .where(Condition.prop("id").eq(notitieId))
                     .first();
    }

}
