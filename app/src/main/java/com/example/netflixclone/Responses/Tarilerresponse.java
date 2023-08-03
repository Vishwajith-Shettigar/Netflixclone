package com.example.netflixclone.Responses;

import com.example.netflixclone.models.Trailersmodel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tarilerresponse {

    @SerializedName("results")
    List<Trailersmodel> trailersmodels;

    public List<Trailersmodel> getTrailersmodels() {
        return trailersmodels;
    }
}
