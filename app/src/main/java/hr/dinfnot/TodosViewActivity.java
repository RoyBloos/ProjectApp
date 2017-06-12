package hr.dinfnot;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Data.ToDo;
import DataProviders.ToDoDataProvider;

public class TodosViewActivity extends AppCompatActivity {
    private ToDo todo;
    private long todoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todos_view_activity);
        todoId = getIntent().getLongExtra("TodoId", -1);
        if(todoId > 0) {
            ToDoLaden();
        }

        FloatingActionButton fabTodobewerken = (FloatingActionButton)findViewById(R.id.todobewerken);
        fabTodobewerken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(TodosViewActivity.this, TodosEditActivity.class);
                myIntent.putExtra("TodoId", todo.getId());
                startActivity(myIntent);
            }
        });

        FloatingActionButton fabTodoverwijderen = (FloatingActionButton)findViewById(R.id.todoverwijderen);
        fabTodoverwijderen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteToDo();
            }
        });
    }

    private void deleteToDo(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("ToDo verwijderen")
                .setMessage("Weet u zeker dat u deze ToDo wilt verwijderen?")
                .setPositiveButton("Ja", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        todo.delete();
                        finish();
                    }

                })
                .setNegativeButton("Nee", null)
                .show();
    }

    @Override
    public void onResume(){
        super.onResume();
        ToDoLaden();
    }

    private void ToDoLaden(){
        ToDoDataProvider provider = ToDoDataProvider.getProvider();
        todo = provider.GeefToDoOpId(todoId);

        TextView titleTextView = (TextView) findViewById(R.id.todo_view_txtTitel);
        TextView datumTextView = (TextView) findViewById(R.id.todo_view_txtDatum);
        TextView todoTextView = (TextView) findViewById(R.id.todo_view_txtTodo);

        DateFormat df = new SimpleDateFormat("dd MMM");
        titleTextView.setText(todo.getTitel());
        datumTextView.setText(df.format(todo.getAanmaakDatum()));
        todoTextView.setText(todo.getTekst());
    }
}
