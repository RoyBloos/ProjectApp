package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Data.Notitie;
import hr.dinfnot.R;

public class NotitieListItemAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Notitie> mDataSource;

    public NotitieListItemAdapter(Context context, ArrayList<Notitie> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.list_item_notitie, parent, false);

        TextView titleTextView = (TextView) rowView.findViewById(R.id.list_item_notitie_txtTitel);
        TextView detailTextView = (TextView) rowView.findViewById(R.id.list_item_notitie_txtTekst);
        TextView aanmaakDatumTextView = (TextView) rowView.findViewById(R.id.list_item_notitie_txtAanmaakDatum);

        Notitie notitie = (Notitie) getItem(position);

        titleTextView.setText(notitie.getTitel());
        detailTextView.setText(notitie.getTekst());
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy ");
        aanmaakDatumTextView.setText(df.format(notitie.getAanmaakDatum()));
        return rowView;
    }
}
