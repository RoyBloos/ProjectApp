package hr.dinfnot;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Adapters.NotitieListItemAdapter;
import Data.Notitie;
import DataProviders.NotitieDataProvider;

public class NotitiesOverzichtActivity extends AppCompatActivity {

    private ListView notitiesListView;

    private ArrayList<Notitie> notities;

    private NotitieListItemAdapter notitieListItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notities_overzicht);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        notitiesListView = (ListView) findViewById(R.id.notities_list_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NotitiesActivity.class);
                startActivity(intent);
            }
        });

        ListView lvNotities = (ListView)findViewById(R.id.notities_list_view);

        lvNotities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View itemView, int index, long id) {
                Notitie notitieToDelete = (Notitie)listView.getItemAtPosition(index);
                ShowDeleteNotitieDialog(notitieToDelete);
            }
        });
    }

    @Override
    protected void onPostResume(){
        super.onPostResume();
        notities = NotitieDataProvider.GetAllNotities();
        HerlaadtNotities();
    }

    private void HerlaadtNotities() {
        if(notitieListItemAdapter == null) {
            notitieListItemAdapter = new NotitieListItemAdapter(this, notities);
            notitiesListView.setAdapter(notitieListItemAdapter);
        } else{
            notitieListItemAdapter.getData().clear();
            notitieListItemAdapter.getData().addAll(notities);
        }
        notitieListItemAdapter.notifyDataSetChanged();
    }

    public void ShowDeleteNotitieDialog(final Notitie notitie){
        if(notitie == null){
            return;
        }

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Notitie verwijderen ");
        alert.setMessage("Wilt u deze notitie verwijderen?");
        alert.setPositiveButton("Ja", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                notitie.delete();
                notities.remove(notitie);
                HerlaadtNotities();
            }
        });
        alert.setNegativeButton("Nee", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }


        });

        alert.show();
    }





}
