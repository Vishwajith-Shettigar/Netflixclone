package com.example.netflixclone.models;


import com.google.gson.annotations.SerializedName;

public class Moviemodel {
    @SerializedName("id")
    int id;

    @SerializedName("original_title")
    String title;
    @SerializedName("name")
    String name;

@SerializedName("first_air_date")
    String firstairdate;

    public String getFirstairdate() {
        return firstairdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("poster_path")
    String image;

   @SerializedName("vote_count")
    Double ratings;
   @SerializedName("overview")
    String desc;

   @SerializedName("release_date")
   String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

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
