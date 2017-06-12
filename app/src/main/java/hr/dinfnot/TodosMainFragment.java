package hr.dinfnot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.ToDoListItemAdapter;
import Data.ToDo;
import DataProviders.ToDoDataProvider;

public class TodosMainFragment extends Fragment{
    View view;
    private ListView todoListView;
    private ArrayList<ToDo> todos;
    private ToDoListItemAdapter todoListItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.todos_main_fragment, container, false);
        todoListView = (ListView)view.findViewById(R.id.todo_list_view);

        todoListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                                {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                        Intent myIntent = new Intent(getActivity(), TodosViewActivity.class);
                                                        myIntent.putExtra("TodoId", todos.get(position).getId());
                                                        getActivity().startActivity(myIntent);
                                                    }
                                                }
        );

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.todotoevoegen);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), TodosEditActivity.class);
                getActivity().startActivity(myIntent);
            }
        });

        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        ToDoDataProvider provider = ToDoDataProvider.getProvider();
        todos = provider.GeefAlleToDos();
        HerlaadtTodos();
    }

    private void HerlaadtTodos() {
        if(todoListItemAdapter == null) {
            todoListItemAdapter = new ToDoListItemAdapter(getContext(), todos);
            todoListView.setAdapter(todoListItemAdapter);
        } else{
            todoListItemAdapter.getData().clear();
            todoListItemAdapter.getData().addAll(todos);
        }
        todoListItemAdapter.notifyDataSetChanged();
    }

    private void ShowToast(){

    }
}
