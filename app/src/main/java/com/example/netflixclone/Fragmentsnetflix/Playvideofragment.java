package com.example.netflixclone.Fragmentsnetflix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.netflixclone.R;
import com.example.netflixclone.models.Moviemodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Playvideofragment extends Fragment {

    Moviemodel data;
 public  Playvideofragment(Moviemodel data)
 {
 this.data=data;
 }

    private BottomNavigationView bottomNavigationView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_playvideofragment, container, false);


        bottomNavigationView = view.findViewById(R.id.videotabs);

        // Set up item click listener for the BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            // Calculate the left and right positions of the indicator based on the selected item

            return false;
        });
        return  view;
    }
}