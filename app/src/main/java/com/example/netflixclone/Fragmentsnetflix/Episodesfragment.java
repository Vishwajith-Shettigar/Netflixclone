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
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;

import java.util.List;


public class Episodesfragment extends Fragment {

RecyclerView episodesrc;
Movieviewmodel movieviewmodel;
int id;
    public Episodesfragment(int id) {
        this.id=id;
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

        episodesrc=view.findViewById(R.id.episodesrc);

        return  view;
    }
}