package com.example.neven.dim_oficial_neven;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> images;
    private ExpandableListView expandableListView;
    private DrawerLayout drawer;
    ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_navigation_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // fragmentTransaction.replace(R.id.content_frame, new InicioFragment(), "InicioFragment");
        // fragmentTransaction.commit();


        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ImageLoaderConfiguration cfg = ImageLoaderConfiguration.createDefault(getApplicationContext());


        imageLoader = ImageLoader.getInstance();
        imageLoader.init(cfg);


        List<Integer> arrow = new ArrayList<Integer>();
        arrow.add(R.drawable.arrow__menu_open);


        images = new ArrayList<Integer>();
        images.add(R.drawable.menu__home);
        images.add(R.drawable.menu__live_scores);
        images.add(R.drawable.menu__news);
        images.add(R.drawable.menu__tv);
        images.add(R.drawable.menu__magazine);
        images.add(R.drawable.menu__store);
        images.add(R.drawable.menu__about);
        images.add(R.drawable.menu__squad);
        images.add(R.drawable.menu__social);
        images.add(R.drawable.menu__academy);
        images.add(R.drawable.menu__tickets);
        images.add(R.drawable.menu__contact_us);


        prepareListDataForNavigationDrawerAndShowIt();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


    }

    private void prepareListDataForNavigationDrawerAndShowIt() {

        List<String> listDataHeaders = new ArrayList<String>();
        HashMap<String, List<String>> listDataChild = new HashMap<String, List<String>>();


        listDataHeaders.add("INICIO");
        listDataHeaders.add("MARCADORES EN VIVO");
        listDataHeaders.add("NOTICIAS");
        listDataHeaders.add("DIM TV");
        listDataHeaders.add("REVISTA");
        listDataHeaders.add("TIENDA");
        listDataHeaders.add("ACERCA DE NOSOTROS");
        listDataHeaders.add("EQUIPO");
        listDataHeaders.add("SOCIAL");
        listDataHeaders.add("ACADEMIAS");
        listDataHeaders.add("BOLETOS");
        listDataHeaders.add("CONTACTENOS");


        List<String> acerca = new ArrayList<String>();
        acerca.add("Quienes somos?");
        acerca.add("Historia");
        acerca.add("Alliados");

        List<String> social = new ArrayList<String>();
        social.add("Facebook");
        social.add("Twitter");
        social.add("Instagram");
        social.add("Youtube");

        List<String> academias = new ArrayList<String>();
        academias.add("Ninos");
        academias.add("Mujeres");
        academias.add("Porristas");

        List<String> empty = new ArrayList<String>();


        listDataChild.put(listDataHeaders.get(0), empty); //null
        listDataChild.put(listDataHeaders.get(1), empty);  //null
        listDataChild.put(listDataHeaders.get(2), empty);  //null
        listDataChild.put(listDataHeaders.get(3), empty);  //null
        listDataChild.put(listDataHeaders.get(4), empty);  //null
        listDataChild.put(listDataHeaders.get(5), empty);  //null
        listDataChild.put(listDataHeaders.get(6), acerca);
        listDataChild.put(listDataHeaders.get(7), empty);  //null
        listDataChild.put(listDataHeaders.get(8), social);
        listDataChild.put(listDataHeaders.get(9), academias);
        listDataChild.put(listDataHeaders.get(10), empty);  //null
        listDataChild.put(listDataHeaders.get(11), empty);  //null


        NavigationDrawerListAdapter adapter = new NavigationDrawerListAdapter(this, images, listDataChild, listDataHeaders);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {


                switch (groupPosition) {

                    case 0:

                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content_frame, new InicioFragment(), "InicioFragment");
                        fragmentTransaction.commit();
                        drawer.closeDrawers();


                        break;


                    case 1:


                        break;


                    case 2:

                        break;


                    case 3:

                        break;


                    case 4:

                        break;


                    case 5:

                        break;


                    case 6:

                        if (!parent.isGroupExpanded(6)) {


                            parent.expandGroup(6);

                        } else {

                            parent.collapseGroup(6);
                        }


                        break;


                    case 7:


                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.content_frame, new EquipoFragment(), "EquipoFragment");
                        fragmentTransaction3.commit();
                        drawer.closeDrawers();


                        break;


                    case 8:


                        if (!parent.isGroupExpanded(8)) {


                            parent.expandGroup(8);
                        } else {

                            parent.collapseGroup(8);
                        }


                        break;


                    case 9:

                        if (!parent.isGroupExpanded(9)) {


                            parent.expandGroup(9);
                        } else {

                            parent.collapseGroup(9);
                        }


                        break;


                    case 10:

                        break;


                    case 11:

                        break;


                }

                return true;


            }

        });


        expandableListView.setAdapter(adapter);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
