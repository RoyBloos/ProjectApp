package Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Data.Notitie;
import DataProviders.NotitieDataProvider;
import hr.dinfnot.R;

public class NotitieListItemAdapter extends BaseAdapter {
    private final NotitieListItemAdapter adapter;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Notitie> mDataSource;
    private Notitie notitie;
    private TextView titleTextView;
    private TextView datumTextView;
    private ImageView favoriteImageView;

    public NotitieListItemAdapter(Context context, ArrayList<Notitie> items) {
        this.mContext = context;
        this.mDataSource = items;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.adapter = this;
    }

    public ArrayList<Notitie> getData(){
        return mDataSource;
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.notities_main_fragment_listitem, parent, false);

        // Get controls
        titleTextView = (TextView) rowView.findViewById(R.id.list_item_notitie_txtTitel);
        datumTextView = (TextView) rowView.findViewById(R.id.list_item_notitie_txtDatum);
        favoriteImageView = (ImageView)rowView.findViewById(R.id.list_item_notitie_imgFavorite);
        notitie = (Notitie) getItem(position);

        //Set control values
        titleTextView.setText(notitie.getTitel());
        datumTextView.setText( new SimpleDateFormat("dd MMM").format(notitie.getAanmaakDatum()));
        favoriteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notitie = (Notitie) getItem(position);
                notitie.setFavoriet(!notitie.getFavoriet());
                notitie.save();
                mDataSource = NotitieDataProvider.getProvider().GeefAlleNotities();
                adapter.notifyDataSetChanged();
            }
        });

        setFavoriteImage();
        return rowView;
    }

    private void setFavoriteImage() {
        if (notitie.getFavoriet()) {
            favoriteImageView.setImageResource(R.drawable.ic_favorite_true);
        } else {
            favoriteImageView.setImageResource(R.drawable.ic_favorite_false);
        }
    }
}
