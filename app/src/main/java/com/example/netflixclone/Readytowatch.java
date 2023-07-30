package com.example.netflixclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class Readytowatch extends AppCompatActivity {
Toolbar rtowtb;
MaterialButton rtowbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readytowatch);
        rtowtb=findViewById(R.id.rtowtb);
        rtowbtn=findViewById(R.id.rtowbtn);
        setSupportActionBar(rtowtb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rtowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Readytowatch.this,Signup.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rtowcross,menu);
        return true;
    }

}