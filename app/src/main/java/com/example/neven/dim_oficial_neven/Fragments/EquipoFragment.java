package com.example.neven.dim_oficial_neven.fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.neven.dim_oficial_neven.*;
import com.example.neven.dim_oficial_neven.activities.SomethingWentWrong;
import com.example.neven.dim_oficial_neven.adapters.EquipoListAdapter;
import com.example.neven.dim_oficial_neven.storage.Multiplayer;
import com.example.neven.dim_oficial_neven.storage.MyApplication;
import com.example.neven.dim_oficial_neven.storage.SinglePlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EquipoFragment extends Fragment {

    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<Multiplayer>> listDataChild;
    private MyApplication app = MyApplication.getInstance();
    private List<SinglePlayer> goalkeepers;
    private List<SinglePlayer> defenders;
    private List<SinglePlayer> middle;
    private List<SinglePlayer> attackers;
    private Multiplayer multiplayer;
    private List<Multiplayer> listOfMultiPlayersDefenders = new ArrayList<Multiplayer>();
    private List<Multiplayer> listOfMultiPlayersGoalKeepers = new ArrayList<Multiplayer>();
    private List<Multiplayer> listOfMultiPlayersMiddle = new ArrayList<Multiplayer>();
    private List<Multiplayer> listOfMultiPlayersAttack = new ArrayList<Multiplayer>();
    private EquipoListAdapter adapter;


    public EquipoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        prepareListData();

        adapter = new EquipoListAdapter(getActivity(), listDataHeader, listDataChild);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_equipo, container, false);

        final WifiManager wifiManager = (WifiManager) v.getContext().getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled()){


        }else {

            AlertDialog.Builder adbIzlaz = new AlertDialog.Builder(v.getContext());

            adbIzlaz.setTitle("Connection problem?");
            adbIzlaz.setMessage("Do you want me to turn on your wifi?");
            adbIzlaz.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    wifiManager.setWifiEnabled(true);


                }
            });

            adbIzlaz.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();

                }
            });

            AlertDialog adIzlaz = adbIzlaz.create();
            adIzlaz.show();


        }

        expListView = (ExpandableListView) v.findViewById(R.id.expandableListViewForEquipoFragment);



        expListView.setAdapter(adapter);


        return v;
    }


    private void prepareListData() {


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Multiplayer>>();


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

        if (app.getPlayers() != null) {


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


        } else {


            Intent intent = new Intent(getContext(), SomethingWentWrong.class);
            startActivity(intent);


        }


        //_______________________________________________


        int counterForGoalkeepers = 0;


        for (SinglePlayer sp : goalkeepers) {


            if (counterForGoalkeepers % 2 == 0) {

                multiplayer = new Multiplayer();


                multiplayer.setLeftPlayer(sp);

                if (counterForGoalkeepers == goalkeepers.size() - 1) {


                    SinglePlayer singlePlayer = new SinglePlayer();
                    singlePlayer.setPlayerID("");
                    singlePlayer.setPlayerName("");
                    singlePlayer.setPlayerNumber("");
                    multiplayer.setRightPlayer(singlePlayer);
                    listOfMultiPlayersGoalKeepers.add(multiplayer);


                }


            } else {

                multiplayer.setRightPlayer(sp);
                listOfMultiPlayersGoalKeepers.add(multiplayer);

            }


            counterForGoalkeepers++;


        }

        //_______________________________________________


        //_______________________________________________


        int counterForDefenders = 0;


        for (SinglePlayer sp : defenders) {


            if (counterForDefenders % 2 == 0) {

                multiplayer = new Multiplayer();


                multiplayer.setLeftPlayer(sp);

                if (counterForDefenders == defenders.size() - 1) {


                    SinglePlayer singlePlayer = new SinglePlayer();
                    singlePlayer.setPlayerID("");
                    singlePlayer.setPlayerName("");
                    singlePlayer.setPlayerNumber("");
                    multiplayer.setRightPlayer(singlePlayer);
                    listOfMultiPlayersDefenders.add(multiplayer);


                }


            } else {

                multiplayer.setRightPlayer(sp);
                listOfMultiPlayersDefenders.add(multiplayer);

            }


            counterForDefenders++;


        }

        //_______________________________________________


        //_______________________________________________


        int counterForMiddle = 0;


        for (SinglePlayer sp : middle) {


            if (counterForMiddle % 2 == 0) {

                multiplayer = new Multiplayer();


                multiplayer.setLeftPlayer(sp);

                if (counterForMiddle == middle.size() - 1) {


                    SinglePlayer singlePlayer = new SinglePlayer();
                    singlePlayer.setPlayerID("");
                    singlePlayer.setPlayerName("");
                    singlePlayer.setPlayerNumber("");
                    multiplayer.setRightPlayer(singlePlayer);
                    listOfMultiPlayersMiddle.add(multiplayer);


                }


            } else {

                multiplayer.setRightPlayer(sp);
                listOfMultiPlayersMiddle.add(multiplayer);

            }


            counterForMiddle++;


        }

        //_______________________________________________

        //_______________________________________________


        int counterForAttack = 0;


        for (SinglePlayer sp : attackers) {


            if (counterForAttack % 2 == 0) {

                multiplayer = new Multiplayer();


                multiplayer.setLeftPlayer(sp);

                if (counterForAttack == attackers.size() - 1) {


                    SinglePlayer singlePlayer = new SinglePlayer();
                    singlePlayer.setPlayerID("");
                    singlePlayer.setPlayerName("");
                    singlePlayer.setPlayerNumber("");
                    multiplayer.setRightPlayer(singlePlayer);
                    listOfMultiPlayersAttack.add(multiplayer);


                }


            } else {

                multiplayer.setRightPlayer(sp);
                listOfMultiPlayersAttack.add(multiplayer);

            }


            counterForAttack++;


        }

        //_______________________________________________


        listDataChild.put(listDataHeader.get(0), listOfMultiPlayersGoalKeepers); // Header, Child data
        listDataChild.put(listDataHeader.get(1), listOfMultiPlayersDefenders);
        listDataChild.put(listDataHeader.get(2), listOfMultiPlayersMiddle);
        listDataChild.put(listDataHeader.get(3), listOfMultiPlayersAttack);


    }

}
