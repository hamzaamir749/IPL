package com.stackBuffers.ipl.Models;

import android.widget.ImageView;

public class TeamModel {


    String T_name, T_Image,id;

    public TeamModel(String t_name, String t_Image, String id) {
        T_name = t_name;
        T_Image = t_Image;
        this.id = id;
    }

    public String getT_name() {
        return T_name;
    }

    public String getT_Image() {
        return T_Image;
    }

    public String getId() {
        return id;
    }
}
