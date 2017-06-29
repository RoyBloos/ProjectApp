package hr.dinfnot;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.NotitieListItemAdapter;
import Data.Notitie;
import DataProviders.NotitieDataProvider;

public class NotitiesMainFragment extends Fragment{
    View view;
    private ListView notitiesListView;
    private ArrayList<Notitie> notities;

    public NotitieListItemAdapter getNotitieListItemAdapter() {
        return notitieListItemAdapter;
    }

    private NotitieListItemAdapter notitieListItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.notities_main_fragment, container, false);
        notitiesListView = (ListView)view.findViewById(R.id.notities_list_view);

        notitiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                            {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Intent myIntent = new Intent(getActivity(), NotitiesViewActivity.class);
                                                    myIntent.putExtra("NotitieId", notities.get(position).getId());
                                                    getActivity().startActivity(myIntent);
                                                }
                                            }
        );

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.notitietoevoegen);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), NotitiesEditActivity.class);
                getActivity().startActivity(myIntent);
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
