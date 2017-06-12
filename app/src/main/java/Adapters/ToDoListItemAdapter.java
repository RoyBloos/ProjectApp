package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Data.ToDo;
import hr.dinfnot.R;

public class ToDoListItemAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ToDo> mDataSource;

    public ToDoListItemAdapter(Context context, ArrayList<ToDo> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public ArrayList<ToDo> getData(){
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
        View rowView = mInflater.inflate(R.layout.todo_main_fragment_listitem, parent, false);

        TextView titleTextView = (TextView) rowView.findViewById(R.id.list_item_todo_txtTitel);
        TextView datumTextView = (TextView) rowView.findViewById(R.id.list_item_todo_txtDatum);

        ToDo todo = (ToDo) getItem(position);

        DateFormat df = new SimpleDateFormat("dd MMM");
        titleTextView.setText(todo.getTitel());
        datumTextView.setText(df.format(todo.getAanmaakDatum()));

        return rowView;
    }


}