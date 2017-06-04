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

import Data.Notitie;
import DataProviders.NotitieDataProvider;

public class NotitiesViewActivity extends AppCompatActivity {
    private Notitie notitie;
    private long notitieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notities_view_activity);
        notitieId = getIntent().getLongExtra("NotitieId", -1);
        if(notitieId > 0) {
            NotitieLaden();
        }

        FloatingActionButton fabNotitiebewerken = (FloatingActionButton)findViewById(R.id.notitiebewerken);
        fabNotitiebewerken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(NotitiesViewActivity.this, NotitiesEditActivity.class);
                myIntent.putExtra("NotitieId", notitie.getId());
                startActivity(myIntent);
            }
        });

        FloatingActionButton fabNotitieverwijderen = (FloatingActionButton)findViewById(R.id.notitieverwijderen);
        fabNotitieverwijderen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteNotitie();
            }
        });
    }

    private void deleteNotitie(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Notitie verwijderen")
                .setMessage("Weet u zeker dat u deze notitie wilt verwijderen?")
                .setPositiveButton("Ja", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        notitie.delete();
                        finish();
                    }

                })
                .setNegativeButton("Nee", null)
                .show();
    }

    @Override
    public void onResume(){
        super.onResume();
        NotitieLaden();
    }

    private void NotitieLaden(){
        NotitieDataProvider provider = NotitieDataProvider.getProvider();
        notitie = provider.GeefNotitieOpId(notitieId);

        TextView titleTextView = (TextView) findViewById(R.id.notitie_view_txtTitel);
        TextView datumTextView = (TextView) findViewById(R.id.notitie_view_txtDatum);
        TextView notitieTextView = (TextView) findViewById(R.id.notitie_view_txtNotitie);

        DateFormat df = new SimpleDateFormat("dd MMM");
        titleTextView.setText(notitie.getTitel());
        datumTextView.setText(df.format(notitie.getAanmaakDatum()));
        notitieTextView.setText(notitie.getTekst());
    }
}
