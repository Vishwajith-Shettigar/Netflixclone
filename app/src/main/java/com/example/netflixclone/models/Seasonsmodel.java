package com.example.netflixclone.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Seasonsmodel {






@SerializedName("episodes")
    List<Episodemodel>episodes;

    public List<Episodemodel> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episodemodel> episodes) {
        this.episodes = episodes;
    }
}
