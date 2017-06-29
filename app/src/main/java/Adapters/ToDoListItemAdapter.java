package Adapters;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Data.Notitie;
import Data.ToDo;
import DataProviders.ToDoDataProvider;
import hr.dinfnot.R;

public class ToDoListItemAdapter extends BaseAdapter {
    private final ToDoListItemAdapter adapter;
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ToDo> mDataSource;
    private int position;
    private ToDo todo;

    public ToDoListItemAdapter(Context context, ArrayList<ToDo> items) {
        this.mContext = context;
        this.mDataSource = items;
        this.mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.adapter = this;
    }

    public ArrayList<ToDo> getData() {
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
        this.todo = (ToDo) getItem(position);

        View rowView = mInflater.inflate(R.layout.todo_main_fragment_listitem, parent, false);
        CheckBox chkGedaan = (CheckBox) rowView.findViewById(R.id.list_item_todo_chkGedaan);
        TextView datumTextView = (TextView) rowView.findViewById(R.id.list_item_todo_txtDatum);
        TextView titelTextView = (TextView) rowView.findViewById(R.id.list_item_todo_txtTitel);

        datumTextView.setText(new SimpleDateFormat("dd MMM").format(todo.getAanmaakDatum()));
        titelTextView.setText(todo.getTitel());
        chkGedaan.setText("");
        chkGedaan.setChecked(todo.getGedaan());
        chkGedaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                todo = (ToDo) getItem(position);
                todo.setGedaan(!todo.getGedaan());
                todo.save();
                mDataSource = ToDoDataProvider.getProvider().GeefAlleToDos();
                adapter.notifyDataSetChanged();
            }
        });

        return rowView;
    }


}
