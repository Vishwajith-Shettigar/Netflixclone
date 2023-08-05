package com.example.netflixclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.netflixclone.Adapters.Moviesadapter;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;

import java.util.List;

public class Moviesa extends AppCompatActivity {
    RecyclerView tvshowsrc;
    Movieviewmodel movieviewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviesa);


        tvshowsrc=findViewById(R.id.tvshowsrc);
        movieviewmodel=new Movieviewmodel();
        movieviewmodel= new ViewModelProvider(this).get(Movieviewmodel.class);



        movieviewmodel.getMymovies().observe(this, new Observer<List<Moviemodel>>() {
            @Override
            public void onChanged(List<Moviemodel> moviemodels) {

                Moviesadapter moviesadapter=new Moviesadapter(getApplicationContext(),moviemodels,true,Moviesa.this,10);
                GridLayoutManager gridLayoutManager= new GridLayoutManager(getApplicationContext(),3);
                tvshowsrc.setLayoutManager(gridLayoutManager);
                tvshowsrc.setAdapter(moviesadapter);

            }
        });
        movieviewmodel.fetchPopularmovies();


    }
    public  void goBackToparentActivtity( Moviemodel data ){

        Log.e("#","its foreign ");

        Intent intent=new Intent(Moviesa.this,Parenntscreen.class);
        intent.putExtra("movies",true);
        intent.putExtra("moviesdata",data);

        startActivity(intent);



    }

}