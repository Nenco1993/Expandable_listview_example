package com.example.neven.dim_oficial_neven;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EquipoFragment extends Fragment {

    ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<SinglePlayer>> listDataChild;
    private MyApplication app = MyApplication.getInstance();
    List<SinglePlayer> goalkeepers;
    List<SinglePlayer> defenders;
    List<SinglePlayer> middle;
    List<SinglePlayer> attackers;


    public EquipoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_equipo, container, false);


        expListView = (ExpandableListView) v.findViewById(R.id.expandableListViewForEquipoFragment);

        prepareListData();


        final EquipoListAdapter adapter = new EquipoListAdapter(getActivity(), listDataHeader, listDataChild);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                Toast.makeText(getActivity(), "you clicked me", Toast.LENGTH_SHORT).show();


                return true;
            }
        });

        expListView.setAdapter(adapter);


        return v;
    }


    private void prepareListData() {


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<SinglePlayer>>();


        // Adding child data
        listDataHeader.add("ARQUEROS");
        listDataHeader.add("DEFENSAS");
        listDataHeader.add("MEDIOCAMPISTAS");
        listDataHeader.add("DELANTEROS");


        // Adding child data
        goalkeepers = new ArrayList<SinglePlayer>();
        defenders = new ArrayList<SinglePlayer>();
        middle = new ArrayList<SinglePlayer>();
        attackers = new ArrayList<SinglePlayer>();


        for (SinglePlayer sp : app.getPlayers()) {


            if (sp.getPlayerFieldPosition().equals("A")) {


                String name1 = sp.getPlayerName();
                goalkeepers.add(sp);


            }

            if (sp.getPlayerFieldPosition().equals("B")) {


                String name2 = sp.getPlayerName();
                defenders.add(sp);


            }

            if (sp.getPlayerFieldPosition().equals("C")) {


                String name3 = sp.getPlayerName();
                middle.add(sp);


            }

            if (sp.getPlayerFieldPosition().equals("D")) {


                String name4 = sp.getPlayerName();
                attackers.add(sp);


            }


        }


        listDataChild.put(listDataHeader.get(0), goalkeepers); // Header, Child data
        listDataChild.put(listDataHeader.get(1), defenders);
        listDataChild.put(listDataHeader.get(2), middle);
        listDataChild.put(listDataHeader.get(3), attackers);


    }

}
