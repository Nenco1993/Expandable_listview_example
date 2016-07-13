package com.example.neven.dim_oficial_neven.storage;

import android.app.Application;

import java.util.List;

/**
 * Created by Neven on 29.6.2016..
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MySingleton.getInstance();

    }

    List<SinglePlayer> players;


    public List<SinglePlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<SinglePlayer> players) {
        this.players = players;
    }
}
