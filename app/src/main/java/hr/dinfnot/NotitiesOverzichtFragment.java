package hr.dinfnot;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.NotitieListItemAdapter;
import Data.Notitie;
import DataProviders.NotitieDataProvider;


public class NotitiesOverzichtFragment extends Fragment {

    View view;
    ViewGroup viewgroup;
    private ListView notitiesListView;
    private ArrayList<Notitie> notities;
    private NotitieListItemAdapter notitieListItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.notities_fragment, null);
        notitiesListView = (ListView)view.findViewById(R.id.notities_list_view);
        notitiesListView.setDivider(this.getResources().getDrawable(R.drawable.dividerColor));
        notitiesListView.setDividerHeight(20);
        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NotitiesActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        NotitieDataProvider provider = NotitieDataProvider.getProvider();
        notities = provider.GeefAlleNotities();
        HerlaadtNotities();
    }

    private void HerlaadtNotities() {
        if(notitieListItemAdapter == null) {
            notitieListItemAdapter = new NotitieListItemAdapter(getContext(), notities);
            notitiesListView.setAdapter(notitieListItemAdapter);
        } else{
            notitieListItemAdapter.getData().clear();
            notitieListItemAdapter.getData().addAll(notities);
        }
        notitieListItemAdapter.notifyDataSetChanged();
    }
}
