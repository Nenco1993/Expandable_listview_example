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
    private HashMap<String, List<String>> listDataChild;
    private MyApplication app = MyApplication.getInstance();
    List<String> goalkeepers;
    List<String> defenders;
    List<String> middle;
    List<String> attack;
    List<String> allPlayers;
    String pozicija;


    public EquipoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_equipo, container, false);

        Toast.makeText(getActivity(), "equipo fragment", Toast.LENGTH_LONG).show();

        expListView = (ExpandableListView) v.findViewById(R.id.expandableListViewForEquipoFragment);

        prepareListData();

        // ListView listview=(ListView) v.findViewById(R.id.listView);
        // ListAdapter lvadapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,middle);
        // listview.setAdapter(lvadapter);

        EquipoListAdapter adapter = new EquipoListAdapter(getActivity(), listDataHeader, listDataChild);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                switch (childPosition) {


                    case 0:

                        Toast.makeText(getActivity(), "00000000", Toast.LENGTH_SHORT).show();

                        break;


                    case 1:

                        Toast.makeText(getActivity(), "111111111", Toast.LENGTH_SHORT).show();


                        break;


                    default:

                        Toast.makeText(getActivity(), "defffff", Toast.LENGTH_SHORT).show();


                        break;


                }


                return true;
            }
        });

        expListView.setAdapter(adapter);


        return v;
    }


    private void prepareListData() {


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        // Adding child data
        listDataHeader.add("ARQUEROS");
        listDataHeader.add("DEFENSAS");
        listDataHeader.add("MEDIOCAMPISTAS");
        listDataHeader.add("DELANTEROS");


        // Adding child data

        goalkeepers = new ArrayList<String>();
        defenders = new ArrayList<String>();
        middle = new ArrayList<String>();
        attack = new ArrayList<String>();

        for (SinglePlayer sp : app.getPlayers()) {


            if (sp.getPlayerFieldPosition().equals("A")) {


                String name1 = sp.getPlayerName();
                goalkeepers.add(name1);


            }

            if (sp.getPlayerFieldPosition().equals("B")) {


                String name2 = sp.getPlayerName();
                defenders.add(name2);


            }

            if (sp.getPlayerFieldPosition().equals("C")) {


                String name3 = sp.getPlayerName();
                middle.add(name3);


            }

            if (sp.getPlayerFieldPosition().equals("D")) {


                String name4 = sp.getPlayerName();
                attack.add(name4);


            }


        }


        listDataChild.put(listDataHeader.get(0), goalkeepers); // Header, Child data
        listDataChild.put(listDataHeader.get(1), defenders);
        listDataChild.put(listDataHeader.get(2), middle);
        listDataChild.put(listDataHeader.get(3), attack);


    }

}
