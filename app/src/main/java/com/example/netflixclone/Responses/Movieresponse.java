package com.example.netflixclone.Responses;

import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;

import java.util.List;

public class Movieresponse {

    private List<Moviemodel> results;

    public List<Moviemodel> getResults() {
        return results;
    }

    public void setResults(List<Moviemodel> results) {
        this.results = results;
    }
}
