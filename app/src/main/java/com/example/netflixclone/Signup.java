package com.example.netflixclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;

public class Signup extends AppCompatActivity {
    Toolbar signuptb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signuptb=findViewById(R.id.signuptb);
        setSupportActionBar(signuptb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.signupmenus,menu);

        for (int i = 0; i < menu.size(); i++) {
            MenuItem menuItem = menu.getItem(i);
            SpannableString spannable = new SpannableString(menuItem.getTitle());
            spannable.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spannable.length(), 0);
            menuItem.setTitle(spannable);
        }
        return true;
    }
}