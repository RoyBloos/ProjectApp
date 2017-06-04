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

import Data.Notitie;
import DataProviders.NotitieDataProvider;

public class NotitiesEditActivity extends AppCompatActivity {
    private Notitie notitie;
    private EditText titleTextView;
    private EditText notitieTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notities_edit_activity);
        Long notitieId = getIntent().getLongExtra("NotitieId", -1);
        if(notitieId > 0) {
            NotitieDataProvider provider = NotitieDataProvider.getProvider();
            notitie = provider.GeefNotitieOpId(notitieId);
        } else{
            notitie = new Notitie("", "");
        }

        titleTextView = (EditText) findViewById(R.id.notitie_edit_txtTitel);
        TextView datumTextView = (TextView) findViewById(R.id.notitie_edit_txtDatum);
        notitieTextView = (EditText) findViewById(R.id.notitie_edit_txtNotitie);

        DateFormat df = new SimpleDateFormat("dd MMM");
        titleTextView.setText(notitie.getTitel());
        datumTextView.setText(df.format(notitie.getAanmaakDatum()));
        notitieTextView.setText(notitie.getTekst());

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.notitiesave);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notitie.setTitel(titleTextView.getText().toString());
                notitie.setTekst(notitieTextView.getText().toString());

                notitie.save();
                finish();
            }
        });
    }
}
