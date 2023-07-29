package com.example.netflixclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import com.example.netflixclone.Adapters.Screensliderad;
import com.example.netflixclone.Fragmentsnetflix.firstslid;
import com.example.netflixclone.Fragmentsnetflix.fourthslide;
import com.example.netflixclone.Fragmentsnetflix.secondslide;
import com.example.netflixclone.Fragmentsnetflix.thirdslide;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ViewPager2 getstartedviewpager;
Screensliderad screensliderad;
Toolbar toolbar;
MaterialButton getstartedbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
toolbar=findViewById(R.id.getstatrtedtb);
        getstartedbtn=findViewById(R.id.getstartedbtn);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);




        getstartedviewpager=findViewById(R.id.getstartedviewpager);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new firstslid());
        fragmentList.add(new secondslide());
        fragmentList.add(new thirdslide());
        fragmentList.add(new fourthslide());

        screensliderad= new Screensliderad(getSupportFragmentManager(), getLifecycle(), fragmentList);
        getstartedviewpager.setAdapter(screensliderad);




        getstartedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Readytowatch.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.submenusfandhelp, menu);
        return true;
    }


}