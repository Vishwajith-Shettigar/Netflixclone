package com.example.netflixclone.models;

import com.google.gson.annotations.SerializedName;

public class Episodemodel {


    @SerializedName("episode_number")
    int epino;

    @SerializedName("name")
    String name;

    @SerializedName("overview")
    String  overview;

    @SerializedName("still_path")
    String image;

    @SerializedName("vote_average")
    String ratings;

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public int getEpino() {
        return epino;
    }

    public void setEpino(int epino) {
        this.epino = epino;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
