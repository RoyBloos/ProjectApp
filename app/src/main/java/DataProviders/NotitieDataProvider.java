package DataProviders;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.List;

import Data.Notitie;

public class NotitieDataProvider {

    private NotitieDataProvider() {
    }

    private static NotitieDataProvider provider;

    public static NotitieDataProvider getProvider() {
        if (provider == null) {
            provider = new NotitieDataProvider();
        }
        return provider;
    }

    public ArrayList<Notitie> GeefAlleNotities() {
        List<Notitie> alleNotitiesDb = Select.from(Notitie.class)
                .orderBy("favoriet desc, aanmaakDatum desc")
                .list();

        ArrayList<Notitie> alleNotities = new ArrayList<>();
        alleNotities.addAll(alleNotitiesDb);

        return alleNotities;
    }

    public Notitie GeefNotitieOpId(Long notitieId) {
        return Select.from(Notitie.class)
                .where(Condition.prop("id").eq(notitieId))
                .first();
    }

}
