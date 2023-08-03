package com.example.netflixclone.models;

import com.google.gson.annotations.SerializedName;

public class Trailersmodel {

    @SerializedName("key")
    public  String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
