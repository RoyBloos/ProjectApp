package DataProviders;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Data.ToDo;

public class ToDoDataProvider {

    private ToDoDataProvider() {
    }

    private static ToDoDataProvider provider;

    public static ToDoDataProvider getProvider() {
        if (provider == null) {
            provider = new ToDoDataProvider();
        }
        return provider;
    }

    public ArrayList<ToDo> GeefAlleToDos() {
        ArrayList<ToDo> alleToDos = new ArrayList<>();
        Iterator<ToDo> todoIterator = Data.ToDo.findAll(ToDo.class);

        while (todoIterator.hasNext()) {
            alleToDos.add(todoIterator.next());
        }

        Collections.reverse(alleToDos);
        return alleToDos;
    }

    public ToDo GeefToDoOpId(Long todoId) {
        return Select.from(ToDo.class)
                .where(Condition.prop("id").eq(todoId))
                .first();
    }

}
