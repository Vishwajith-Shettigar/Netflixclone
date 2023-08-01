package com.example.netflixclone.models;


import com.google.gson.annotations.SerializedName;

public class Moviemodel {
    @SerializedName("id")
    int id;

    @SerializedName("name")
    String title;
    @SerializedName("poster_path")
    String image;

   @SerializedName("vote_count")
    Double ratings;
   @SerializedName("overview")
    String desc;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
