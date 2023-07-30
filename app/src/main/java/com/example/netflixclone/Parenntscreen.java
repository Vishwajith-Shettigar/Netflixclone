package com.example.netflixclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

public class Parenntscreen extends AppCompatActivity {
    Toolbar parenttb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parenntscreen);
        parenttb=findViewById(R.id.parenttb);
        setSupportActionBar(parenttb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.parentmenus,menu);

        return true;
    }
}