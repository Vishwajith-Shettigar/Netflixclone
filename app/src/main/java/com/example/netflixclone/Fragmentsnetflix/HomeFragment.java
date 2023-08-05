package com.example.netflixclone.Fragmentsnetflix;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.netflixclone.Adapters.Moviesadapter;
import com.example.netflixclone.Moviesa;
import com.example.netflixclone.Parenntscreen;
import com.example.netflixclone.R;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.tvshows;
import com.example.netflixclone.viewmodels.Movieviewmodel;

import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView moviesrc,trendingnowrc,onlyonnetflixrc,tvdramasrc,horrorrc;
    Movieviewmodel movieviewmodel;
    ScrollView scrollview;
    TextView tvshowsmenu,moviesmenu;
    LinearLayoutManager layoutManagermovie,layoutManagertrending,layoutManageronlyn,layoutManagertv,layoutManagerhorror;
    private int moviesrcp = 0;
    private int trendingrcp = 0;
    private int onlyrcp = 0;
    private int tvrcp = 0;
    private int horrorrcp = 0;

    private int scrollPosition = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            scrollPosition = savedInstanceState.getInt("scrollPosition", 0);
            scrollview.post(new Runnable() {
                @Override
                public void run() {
                    scrollview.scrollTo(0, scrollPosition);
                }
            });




            moviesrcp = savedInstanceState.getInt("moviesrcp", 0);
            moviesrc.scrollToPosition(moviesrcp);

            trendingrcp = savedInstanceState.getInt("trendingrcp", 0);
            trendingnowrc.scrollToPosition(trendingrcp);

            onlyrcp = savedInstanceState.getInt("onlyrcp", 0);
            onlyonnetflixrc.scrollToPosition(onlyrcp);

            tvrcp = savedInstanceState.getInt("tvrcp", 0);
            tvdramasrc.scrollToPosition(tvrcp);

            horrorrcp = savedInstanceState.getInt("horrorrcp", 0);
            horrorrc.scrollToPosition(horrorrcp);
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current scroll position before replacing the fragment
        scrollPosition = scrollview.getScrollY();
        outState.putInt("scrollPosition", scrollPosition);



        moviesrcp = layoutManagermovie.findFirstVisibleItemPosition();
        outState.putInt("moviesrcp", moviesrcp);

        trendingrcp = layoutManagertrending.findFirstVisibleItemPosition();
        outState.putInt("trendingrcp", trendingrcp);

        onlyrcp = layoutManageronlyn.findFirstVisibleItemPosition();
        outState.putInt("onlyrcp", onlyrcp);

        tvrcp = layoutManagertv.findFirstVisibleItemPosition();
        outState.putInt("tvrcp", tvrcp);

        horrorrcp = layoutManagerhorror.findFirstVisibleItemPosition();
        outState.putInt("horrorrcp", horrorrcp);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);

        // Inflate the layout for this fragment
        scrollview=view.findViewById(R.id.scrollview);
        moviesrc=view.findViewById(R.id.pastyearrv);
        trendingnowrc=view.findViewById(R.id.trendingnowrc);
        onlyonnetflixrc=view.findViewById(R.id.onlyonnetflixrc);
        tvdramasrc=view.findViewById(R.id.tvdramasrc);
        horrorrc=view.findViewById(R.id.horrorrc);
        tvshowsmenu=view.findViewById(R.id.tvshowsmenu);
        moviesmenu=view.findViewById(R.id.moviesmenu);
        movieviewmodel=new Movieviewmodel();
        movieviewmodel= new ViewModelProvider(this).get(Movieviewmodel.class);



        tvshowsmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), tvshows.class));
            }
        });

        moviesmenu.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               startActivity(new Intent(getActivity(), Moviesa.class));
                                           }
                                       });
        movieviewmodel.getMymovies().observe(getViewLifecycleOwner(), new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {
                Log.e("#","lol  "+moviemodels.get(1).getImage()+"");
                Moviesadapter moviesadapter=new Moviesadapter(getActivity(),moviemodels);
                 layoutManagermovie = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                moviesrc.setLayoutManager(layoutManagermovie);
                moviesrc.setAdapter(moviesadapter);

            }
        });

        movieviewmodel.getTrendingnow().observe(getViewLifecycleOwner(), new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {
                Log.e("#","lol  "+moviemodels.get(1).getImage()+"");
                Moviesadapter moviesadapter=new Moviesadapter(getActivity(),moviemodels);
               layoutManagertrending = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                trendingnowrc.setLayoutManager(layoutManagertrending);
                trendingnowrc.setAdapter(moviesadapter);

            }
        });

        movieviewmodel.getOnlyonnetflix().observe(getViewLifecycleOwner(), new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {
                Log.e("#","lol  "+moviemodels.get(1).getImage()+"");
                Moviesadapter moviesadapter=new Moviesadapter(getActivity(),moviemodels);
               layoutManageronlyn = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                onlyonnetflixrc.setLayoutManager(layoutManageronlyn);
                onlyonnetflixrc.setAdapter(moviesadapter);

            }
        });

        movieviewmodel.getTvdramas().observe(getViewLifecycleOwner(), new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {
                Log.e("#","lol  "+moviemodels.get(1).getImage()+"");
                Moviesadapter moviesadapter=new Moviesadapter(getActivity(),moviemodels);
             layoutManagertv = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                tvdramasrc.setLayoutManager(layoutManagertv);
                tvdramasrc.setAdapter(moviesadapter);

            }
        });

        movieviewmodel.getHorrormovies().observe(getViewLifecycleOwner(), new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {
                Log.e("#","lol  "+moviemodels.get(1).getImage()+"");
                Moviesadapter moviesadapter=new Moviesadapter(getActivity(),moviemodels);
                layoutManagerhorror = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                horrorrc.setLayoutManager(layoutManagerhorror);
                horrorrc.setAdapter(moviesadapter);

            }
        });

        movieviewmodel.fetchPopularmovies();
        movieviewmodel.fetchTrendingnow();
        movieviewmodel.fetchOnlyonnetflix();
        movieviewmodel.fetchTvdramas();
        movieviewmodel.fetchHorrormovies();


        return view;
    }
}