package com.example.neven.dim_oficial_neven.storage;

import java.io.Serializable;

/**
 * Created by Neven on 1.7.2016..
 */
public class SinglePlayer implements Serializable {


    private String playerID;
    private String playerName;
    private String playerNation;
    private String playerAge;
    private String playerPosition;
    private String playerNumber;
    private String playerDominantHand;
    private String playerFieldPosition;
    private String playerPicture;
    private String playerSpeed;
    private String playerDefense;
    private String playerAttack;
    private String playerStrength;
    private String playerTechnique;
    private String playerPunch;

    public String getPlayerAttack() {
        return playerAttack;
    }

    public void setPlayerAttack(String playerAttack) {
        this.playerAttack = playerAttack;
    }

    public String getPlayerDefense() {
        return playerDefense;
    }

    public void setPlayerDefense(String playerDefense) {
        this.playerDefense = playerDefense;
    }

    public String getPlayerPunch() {
        return playerPunch;
    }

    public void setPlayerPunch(String playerPunch) {
        this.playerPunch = playerPunch;
    }

    public String getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(String playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public String getPlayerStrength() {
        return playerStrength;
    }

    public void setPlayerStrength(String playerStrength) {
        this.playerStrength = playerStrength;
    }

    public String getPlayerTechnique() {
        return playerTechnique;
    }

    public void setPlayerTechnique(String playerTechnique) {
        this.playerTechnique = playerTechnique;
    }

    public String getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(String playerAge) {
        this.playerAge = playerAge;
    }

    public String getPlayerDominantHand() {
        return playerDominantHand;
    }

    public void setPlayerDominantHand(String playerDominantHand) {
        this.playerDominantHand = playerDominantHand;
    }

    public String getPlayerFieldPosition() {
        return playerFieldPosition;
    }

    public void setPlayerFieldPosition(String playerFieldPosition) {
        this.playerFieldPosition = playerFieldPosition;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerNation() {
        return playerNation;
    }

    public void setPlayerNation(String playerNation) {
        this.playerNation = playerNation;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerPicture() {
        return playerPicture;
    }

    public void setPlayerPicture(String playerPicture) {
        this.playerPicture = playerPicture;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }
}
