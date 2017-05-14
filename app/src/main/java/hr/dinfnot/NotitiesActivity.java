package hr.dinfnot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import DataProviders.NotitieDataProvider;

public class NotitiesActivity extends AppCompatActivity {

    public NotitiesActivity(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notities);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabAddNotitie = (FloatingActionButton) findViewById(R.id.fabAddNotitie);
        fabAddNotitie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotitieOpslaan(view);
            }
        });
    }

    public void NotitieOpslaan(View view) {
        EditText titel = (EditText)findViewById(R.id.txtTitel);
        EditText notitie = (EditText)findViewById(R.id.txtNotitie);

        NotitieDataProvider provider = NotitieDataProvider.getProvider();
        provider.OpslaanNotitie(titel.getText().toString(), notitie.getText().toString(), null);

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
