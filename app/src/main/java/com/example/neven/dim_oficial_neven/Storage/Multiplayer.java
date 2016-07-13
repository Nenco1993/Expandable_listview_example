package com.example.neven.dim_oficial_neven.storage;

import java.io.Serializable;

/**
 * Created by Neven on 12.7.2016..
 */
public class Multiplayer implements Serializable {


    private SinglePlayer leftPlayer;
    private SinglePlayer rightPlayer;


    public SinglePlayer getLeftPlayer() {
        return leftPlayer;
    }

    public void setLeftPlayer(SinglePlayer leftPlayer) {
        this.leftPlayer = leftPlayer;
    }

    public SinglePlayer getRightPlayer() {
        return rightPlayer;
    }

    public void setRightPlayer(SinglePlayer rightPlayer) {
        this.rightPlayer = rightPlayer;
    }
}
