package com.example.netflixclone.Fragmentsnetflix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.netflixclone.Adapters.Moviesadapter;
import com.example.netflixclone.R;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;

import java.util.List;


public class Morelikethisfragment extends Fragment {

RecyclerView mltrc;
int genreid;

Movieviewmodel movieviewmodel;

List<Moviemodel>morelikthisdata;

public  Morelikethisfragment(int genreid)
{
this.genreid=genreid;
}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_morelikethisfragment, container, false);

        mltrc=view.findViewById(R.id.mltrc);

        Log.e("#",genreid+"");

        movieviewmodel=new Movieviewmodel();
        movieviewmodel  = new ViewModelProvider(this).get(Movieviewmodel.class);

movieviewmodel.getMorelikethis().observe(getViewLifecycleOwner(), new Observer<List<Moviemodel>>() {
    @Override
    public void onChanged(List<Moviemodel> moviemodels) {
        Log.e("#","morevlike this  "+moviemodels.get(0).getImage());

        Moviesadapter moviesadapter=new Moviesadapter(getActivity(),moviemodels);
        GridLayoutManager layoutManageronlyn = new GridLayoutManager(getActivity(), 3);
        mltrc.setLayoutManager(layoutManageronlyn);
        mltrc.setAdapter(moviesadapter);

    }
});



        movieviewmodel.fetchMorelikethis(genreid);
        return  view;
    }
}