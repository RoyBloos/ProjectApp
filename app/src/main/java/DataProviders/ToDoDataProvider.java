package DataProviders;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import Data.ToDo;
import Data.ToDoCategorie;

public class ToDoDataProvider {

    private ToDoDataProvider(){}

    private static ToDoDataProvider provider;

    public static ToDoDataProvider getProvider(){
        if(provider == null){
            provider = new ToDoDataProvider();
        }
        return provider;
    }

    public ArrayList<ToDo> GeefAlleToDos()
    {
        List<ToDo> x =  Select.from(ToDo.class)
                .orderBy("")
                .list();



        ArrayList<ToDo> alleToDos = new ArrayList<>();
        Iterator<ToDo> todoIterator = Data.ToDo.findAll(ToDo.class);

        while (todoIterator.hasNext()) {
            alleToDos.add(todoIterator.next());
        }
        Collections.reverse(alleToDos);
        return alleToDos;
    }

    public boolean OpslaanToDo(String titel, String todo, ToDoCategorie todoCategorie)
    {
        try{
            if(titel != null && todo != null) {
                ToDo newToDo = new ToDo(titel, todo);
                newToDo.setCategorie(todoCategorie);
                newToDo.save();
                return true;
            }
        } catch (Exception ex){
            Exception p = ex;
        }
        return false;
    }

    public void OpslaanToDoCategorie(String titel, String beschrijving){

        ToDoCategorie newCategorie = new ToDoCategorie();
        newCategorie.setTitel(titel);
        newCategorie.setBeschrijving(beschrijving);
        newCategorie.save();
    }

    public ToDoCategorie GeefToDoCategorieOpTitel(String titel){
        return Select.from(ToDoCategorie.class)
                .where(Condition.prop("titel").eq(titel))
                .first();
    }

    public ToDo GeefToDoOpId(Long todoId){
        return Select.from(ToDo.class)
                .where(Condition.prop("id").eq(todoId))
                .first();
    }

}
