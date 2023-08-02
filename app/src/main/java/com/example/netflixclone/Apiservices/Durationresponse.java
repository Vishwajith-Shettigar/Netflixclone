package com.example.netflixclone.Apiservices;

import com.example.netflixclone.models.Durationmodel;
import com.example.netflixclone.models.Moviemodel;

import java.util.List;

public class Durationresponse {
    private Durationmodel results;

    public Durationmodel getResults() {
        return results;
    }

    public void setResults(Durationmodel results) {
        this.results = results;
    }
}
