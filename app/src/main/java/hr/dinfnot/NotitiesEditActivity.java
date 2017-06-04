package hr.dinfnot;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import Data.Notitie;
import DataProviders.NotitieDataProvider;

public class NotitiesEditActivity extends AppCompatActivity {
    private Notitie notitie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notities_edit_activity);
        Long notitieId = getIntent().getLongExtra("NotitieId", -1);
        if(notitieId > 0) {
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
//        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.notitieverwijderen);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), NotitiesActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notitie_edit, menu);
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
