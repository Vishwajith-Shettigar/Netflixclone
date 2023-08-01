package com.example.netflixclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.netflixclone.Adapters.Moviesadapter;
import com.example.netflixclone.Fragmentsnetflix.DownloadsFragment;
import com.example.netflixclone.Fragmentsnetflix.HomeFragment;
import com.example.netflixclone.Fragmentsnetflix.NewsFragment;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Parenntscreen extends AppCompatActivity {
    Toolbar parenttb;

RecyclerView moviesrc,trendingnowrc,onlyonnetflixrc,tvdramasrc,horrorrc;
Movieviewmodel movieviewmodel;
BottomNavigationView bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parenntscreen);
        parenttb=findViewById(R.id.parenttb);

        bottom_navigation=findViewById(R.id.bottom_navigation);



        setSupportActionBar(parenttb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


       getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new HomeFragment())
                       .commit();



        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Homemenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new HomeFragment())
                                .commit();


                        break;
                    case R.id.newsmenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new NewsFragment())
                                .commit();

                        break;

                    case R.id.downloadsmenu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framecontainer,new DownloadsFragment())
                                .commit();

                        break;



                }
                return true;
            }
        });






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.parentmenus,menu);

        return true;
    }
}