package com.example.neven.dim_oficial_neven.storage;

/**
 * Created by Neven on 29.6.2016..
 */
public class MySingleton {

    private static MySingleton ourInstance = new MySingleton();

    public static MySingleton getInstance() {
        return ourInstance;
    }

    private MySingleton() {
    }
}
