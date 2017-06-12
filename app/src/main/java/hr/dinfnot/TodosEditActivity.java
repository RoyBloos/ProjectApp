package hr.dinfnot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Data.ToDo;
import DataProviders.ToDoDataProvider;

public class TodosEditActivity extends AppCompatActivity {
    private ToDo todo;
    private EditText titleTextView;
    private EditText todoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todos_edit_activity);
        Long todoId = getIntent().getLongExtra("todoId", -1);
        if(todoId > 0) {
            ToDoDataProvider provider = ToDoDataProvider.getProvider();
            todo = provider.GeefToDoOpId(todoId);
        } else{
            todo = new ToDo("", "");
        }

        titleTextView = (EditText) findViewById(R.id.todo_edit_txtTitel);
        TextView datumTextView = (TextView) findViewById(R.id.todo_edit_txtDatum);
        todoTextView = (EditText) findViewById(R.id.todo_edit_txtTodo);

        DateFormat df = new SimpleDateFormat("dd MMM");
        titleTextView.setText(todo.getTitel());
        datumTextView.setText(df.format(todo.getAanmaakDatum()));
        todoTextView.setText(todo.getTekst());

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.todossave);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todo.setTitel(titleTextView.getText().toString());
                todo.setTekst(todoTextView.getText().toString());

                todo.save();
                finish();
            }
        });
    }
}
