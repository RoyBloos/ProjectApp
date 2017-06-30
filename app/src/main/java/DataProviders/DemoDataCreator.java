package DataProviders;

import java.util.ArrayList;
import java.util.List;

public class DemoDataCreator {

    public static void CreateDemoData() {
        DemoDataVisitor demoDataVisitor = new DemoDataVisitor();
        for (IDemoDataVisitable provider : providers) {
            provider.accept(demoDataVisitor);
        }
    }

    private static List<IDemoDataVisitable> providers = new ArrayList<IDemoDataVisitable>() {
        {
            add(NotitieDataProvider.getProvider());
            add(ToDoDataProvider.getProvider());
        }
    };
}
