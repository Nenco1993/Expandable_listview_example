package com.example.neven.dim_oficial_neven;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    private MyApplication app = MyApplication.getInstance();


    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.fragment_inicio,container,false);



        ListView listView=(ListView) v.findViewById(R.id.listViewForInicio);

        //ListAdapter adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,app.getListOfPlayerPictures());
       // listView.setAdapter(adapter);



        return v;
    }

}
