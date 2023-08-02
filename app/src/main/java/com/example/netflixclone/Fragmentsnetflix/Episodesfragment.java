package com.example.netflixclone.Fragmentsnetflix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.netflixclone.Adapters.Moviesadapter;
import com.example.netflixclone.R;
import com.example.netflixclone.models.Durationmodel;
import com.example.netflixclone.models.Episodemodel;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.models.Noofseasonsmodel;
import com.example.netflixclone.models.Seasonsmodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;

import java.util.List;


public class Episodesfragment extends Fragment {

RecyclerView episodesrc;
Movieviewmodel movieviewmodel;
int id,noofseasonss;
    public Episodesfragment(int id,int noofseasonss) {
        this.id=id;
        this.noofseasonss=noofseasonss;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_episodesfragment, container, false);
        movieviewmodel = new Movieviewmodel();
        movieviewmodel= new ViewModelProvider(this).get(Movieviewmodel.class);
        episodesrc=view.findViewById(R.id.episodesrc);
Log.e("#","no of seasons "+ noofseasonss);



        movieviewmodel.getEpisode().observe(getViewLifecycleOwner(), new Observer<List<Episodemodel>>() {
            @Override
            public void onChanged(List<Episodemodel> episodemodel) {


            }
        });
        if(noofseasonss>0) {
            movieviewmodel.fetchEpisodes(id);

        }


        return  view;
    }
}