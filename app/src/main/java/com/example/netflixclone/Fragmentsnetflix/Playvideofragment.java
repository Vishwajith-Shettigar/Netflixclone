package com.example.netflixclone.Fragmentsnetflix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.netflixclone.R;
import com.example.netflixclone.models.Moviemodel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Playvideofragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Playvideofragment extends Fragment {

    Moviemodel data;
 public  Playvideofragment(Moviemodel data)
 {
 this.data=data;
 }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_playvideofragment, container, false);
    }
}