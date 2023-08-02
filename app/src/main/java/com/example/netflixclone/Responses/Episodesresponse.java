package com.example.netflixclone.Responses;

import com.example.netflixclone.models.Episodemodel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Episodesresponse {
    @SerializedName("episodes")
    private List<Episodemodel> episodes;

    public List<Episodemodel> getEpisodes() {
        return episodes;
    }
}
