package com.example.neven.dim_oficial_neven.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.neven.dim_oficial_neven.storage.MyApplication;
import com.example.neven.dim_oficial_neven.R;


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


        View v = inflater.inflate(R.layout.fragment_inicio, container, false);









        return v;
    }




}
