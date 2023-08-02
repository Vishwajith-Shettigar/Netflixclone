package com.example.netflixclone.models;

import com.google.gson.annotations.SerializedName;

public class Noofseasonsmodel {

    @SerializedName("number_of_seasons")
    int noofseason;

    public int getNoofseason() {
        return noofseason;
    }

    public void setNoofseason(int noofseason) {
        this.noofseason = noofseason;
    }
}
