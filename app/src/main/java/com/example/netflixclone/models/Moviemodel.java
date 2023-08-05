package com.example.netflixclone.models;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Moviemodel  implements Parcelable {
    @SerializedName("id")
    int id;

    @SerializedName("original_title")
    String title;
    @SerializedName("name")
    String name;

@SerializedName("first_air_date")
    String firstairdate;

    protected Moviemodel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        name = in.readString();
        firstairdate = in.readString();
        image = in.readString();
        if (in.readByte() == 0) {
            ratings = null;
        } else {
            ratings = in.readDouble();
        }
        desc = in.readString();
        year = in.readString();
        genre_ids = new ArrayList<>();
        in.readList(genre_ids, Integer.class.getClassLoader());
    }

    public static final Creator<Moviemodel> CREATOR = new Creator<Moviemodel>() {
        @Override
        public Moviemodel createFromParcel(Parcel in) {
            return new Moviemodel(in);
        }

        @Override
        public Moviemodel[] newArray(int size) {
            return new Moviemodel[size];
        }
    };

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

   @SerializedName("genre_ids")
    List<Integer>genre_ids;

    public void setFirstairdate(String firstairdate) {
        this.firstairdate = firstairdate;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(name);
        parcel.writeString(firstairdate);
        parcel.writeString(image);
        if (ratings == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(ratings);
        }
        parcel.writeString(desc);
        parcel.writeString(year);
        parcel.writeList(genre_ids);
    }
}
