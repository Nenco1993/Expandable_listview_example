package com.example.neven.dim_oficial_neven.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.example.neven.dim_oficial_neven.R;

public class SomethingWentWrong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_something_went_wrong);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pocetniScreen();


    }

    public void pocetniScreen() {

        Thread tajmer = new Thread() {

            public void run() {

                try {

                    sleep(3000);


                } catch (InterruptedException e) {


                    e.printStackTrace();
                } finally {


                    finishAffinity();


                }


            }


        };

        tajmer.start();


    }

}
