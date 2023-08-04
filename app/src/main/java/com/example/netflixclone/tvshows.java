package com.example.netflixclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.netflixclone.Adapters.Moviesadapter;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;

import java.util.List;

public class tvshows extends AppCompatActivity {
    RecyclerView tvshowsrc;
    Movieviewmodel movieviewmodel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshows);

        tvshowsrc=findViewById(R.id.tvshowsrc);
        movieviewmodel=new Movieviewmodel();
        movieviewmodel= new ViewModelProvider(this).get(Movieviewmodel.class);



        movieviewmodel.getTvdramas().observe(this, new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {

                Moviesadapter moviesadapter=new Moviesadapter(getApplicationContext(),moviemodels,true);
                GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),3);
                tvshowsrc.setLayoutManager(gridLayoutManager);
                tvshowsrc.setAdapter(moviesadapter);

            }
        });
        movieviewmodel.fetchTvdramas();


    }
public  void goBackToparentActivtity(){


}

}