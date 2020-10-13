package com.stackBuffers.ipl.Models;

public class TeamDetailModel {
    public String playername,isforginer,type;

    public TeamDetailModel(String playername, String isforginer, String type) {
        this.playername = playername;
        this.isforginer = isforginer;
        this.type = type;
    }

    public String getPlayername() {
        return playername;
    }

    public String getIsforginer() {
        return isforginer;
    }

    public String getType() {
        return type;
    }
}
