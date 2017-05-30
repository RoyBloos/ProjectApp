package hr.dinfnot;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import Data.NotitieCategorie;
import DataProviders.NotitieDataProvider;

public class NotitiesActivity extends AppCompatActivity {

    public NotitiesActivity(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notities_add_activity);
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
        NotitieCategorie categorie = provider.GeefNotitieCategorieOpTitel("Categorie titel");

        provider.OpslaanNotitie(titel.getText().toString(), notitie.getText().toString(), categorie);

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
