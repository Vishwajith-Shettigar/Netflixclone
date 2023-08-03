package com.example.netflixclone.Responses;

import com.example.netflixclone.models.Episodemodel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Episodesresponse {

    @SerializedName("episodes")
    public List<Episodemodel> episodesmodel;

    public List<Episodemodel> getEpisodesmodel() {
        return episodesmodel;
    }
}
