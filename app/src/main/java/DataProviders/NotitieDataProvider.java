package DataProviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Data.Notitie;

public class NotitieDataProvider {

    public static ArrayList<Notitie> GetAllNotities()
    {
        ArrayList<Notitie> alleNotities = new ArrayList<>();
        //try {
            Iterator<Notitie> notitieIterator = Data.Notitie.findAll(Notitie.class);

            while (notitieIterator.hasNext()) {
                alleNotities.add(notitieIterator.next());
            }
        //} catch (Exception ex){
        //    Exception p = ex;
        //}
        return alleNotities;
    }

    public static boolean SaveNotitie(String titel, String notitie)
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
