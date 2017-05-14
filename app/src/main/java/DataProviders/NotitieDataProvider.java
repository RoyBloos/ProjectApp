package DataProviders;

import java.util.ArrayList;
import java.util.Iterator;

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
        ArrayList<Notitie> alleNotities = new ArrayList<>();
        Iterator<Notitie> notitieIterator = Data.Notitie.findAll(Notitie.class);

        while (notitieIterator.hasNext()) {
            alleNotities.add(notitieIterator.next());
        }

        return alleNotities;
    }

    public boolean OpslaanNotitie(String titel, String notitie, NotitieCategorie notitieCategorie)
    {
        try{
        if(titel != null && notitie != null) {
            Notitie newNotitie = new Notitie(titel, notitie);
            newNotitie.save();
            return true;
        }
        } catch (Exception ex){
            Exception p = ex;
        }
        return false;
    }
}
