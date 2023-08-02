package com.example.netflixclone.models;

import com.google.gson.annotations.SerializedName;

public class Durationmodel {

    @SerializedName("id")
    int id;

    @SerializedName("runtime")
    String duration;

    public int getId() {
        return id;
    }

    public String getDuration() {
        return duration;
    }
}
