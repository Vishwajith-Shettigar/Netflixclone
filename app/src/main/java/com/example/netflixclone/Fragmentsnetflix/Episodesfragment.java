package com.example.netflixclone.Fragmentsnetflix;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netflixclone.Adapters.Moviesadapter;
import com.example.netflixclone.Adapters.episodesadapter;
import com.example.netflixclone.R;
import com.example.netflixclone.models.Durationmodel;
import com.example.netflixclone.models.Episodemodel;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.models.Noofseasonsmodel;
import com.example.netflixclone.models.Seasonsmodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import java.util.List;


public class Episodesfragment extends Fragment {

RecyclerView episodesrc;
Movieviewmodel movieviewmodel;
MaterialButton seasonnobtn;
 BottomSheetDialog bottomSheetDialog;

int id,noofseasonss;
    public Episodesfragment(int id,int noofseasonss) {
        this.id=id;
        this.noofseasonss=noofseasonss;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_episodesfragment, container, false);
        movieviewmodel = new Movieviewmodel();
        movieviewmodel= new ViewModelProvider(this).get(Movieviewmodel.class);
        episodesrc=view.findViewById(R.id.episodesrc);
        seasonnobtn=view.findViewById(R.id.seasonnobtn);


Log.e("#","no of seasons "+ noofseasonss);



        movieviewmodel.getEpisode().observe(getViewLifecycleOwner(), new Observer<List<Episodemodel>>() {
            @Override
            public void onChanged(List<Episodemodel> episodemodel) {
                episodesadapter episodesadapter=new episodesadapter(getContext(),episodemodel);

                LinearLayoutManager      layoutManagertv = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                episodesrc.setLayoutManager(layoutManagertv);
                episodesrc.setAdapter(episodesadapter);






            }
        });
        if(noofseasonss>0) {
            seasonnobtn.setText("Season 1");
            Log.e("#",noofseasonss+ "-----------");
            movieviewmodel.fetchEpisodes(id,1);



        }



        seasonnobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               bottomSheetDialog = new BottomSheetDialog(getActivity());
             View view1=   addTextviewtolayout( noofseasonss);
                bottomSheetDialog.setContentView(view1);


                bottomSheetDialog.show();



            }
        });

        return  view;
    }

    private  void ShowEpisodes(int sid)
    {
        seasonnobtn.setText("Season "+sid);
        movieviewmodel.fetchEpisodes(id,sid);



    }

    private  View addTextviewtolayout(int noofseasonss) {
        View view = getLayoutInflater().inflate(R.layout.bottomshettdialogseasons, null);


        LinearLayout linearLayout = view.findViewById(R.id.seasonsnames);
        MaterialButton materialButton=view.findViewById(R.id.closedialogue);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

        // Create a new TextView
        for (int i = 1; i <= noofseasonss; i++) {
            TextView textView = new TextView(getContext());
            textView.setText("Season "+i);
            textView.setTextSize(20);

            textView.setId(i);
            if(i==1) {
                textView.setTextColor(getResources().getColor(R.color.white));
            }else{
                textView.setTextColor(getResources().getColor(R.color.gray));
            }

            // Add the new TextView to the parent LinearLayout
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, // Width
                    ViewGroup.LayoutParams.WRAP_CONTENT  // Height
            );
            layoutParams.setMargins(30, 30, 30, 30); // Set margins (left, top, right, bottom)
            textView.setLayoutParams(layoutParams);

            linearLayout.addView(textView);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ShowEpisodes(view.getId());
                    bottomSheetDialog.dismiss();
                }
            });



        }
        return view;
    }
}