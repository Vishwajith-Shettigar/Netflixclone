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
import android.widget.TextView;

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
TextView dotone,dottwo,dotthree,dotfour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
toolbar=findViewById(R.id.getstatrtedtb);
        getstartedbtn=findViewById(R.id.getstartedbtn);
        getstartedviewpager=findViewById(R.id.getstartedviewpager);
        dotone=findViewById(R.id.dotone);
        dottwo=findViewById(R.id.dottwo);
        dotthree=findViewById(R.id.dotthree);
        dotfour=findViewById(R.id.dotfour);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);





        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new firstslid());
        fragmentList.add(new secondslide());
        fragmentList.add(new thirdslide());
        fragmentList.add(new fourthslide());

        screensliderad= new Screensliderad(getSupportFragmentManager(), getLifecycle(), fragmentList);
        getstartedviewpager.setAdapter(screensliderad);



        // handling dots for sliding
        getstartedviewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Log.e("#",position+"");
                dotone.setBackgroundResource(R.drawable.dotsfragback);
                dottwo.setBackgroundResource(R.drawable.dotsfragback);
                dotthree.setBackgroundResource(R.drawable.dotsfragback);

                dotfour.setBackgroundResource(R.drawable.dotsfragback);
                if(position==0)
                    dotone.setBackgroundResource(R.drawable.dotsfragactive);
                else if(position==1)
                    dottwo.setBackgroundResource(R.drawable.dotsfragactive);
                else if (position==2)
                    dotthree.setBackgroundResource(R.drawable.dotsfragactive);
                else if (position==3)
                    dotfour.setBackgroundResource(R.drawable.dotsfragactive);


            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        Log.e("#",id+"");

        switch (id)
        {
            case R.id.signinmenu:
                startActivity(new Intent(MainActivity.this,Signin.class));
        }
        return super.onOptionsItemSelected(item);
    }
}