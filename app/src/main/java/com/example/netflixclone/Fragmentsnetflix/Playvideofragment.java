package com.example.netflixclone.Fragmentsnetflix;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.netflixclone.R;
import com.example.netflixclone.models.Durationmodel;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.models.Noofseasonsmodel;
import com.example.netflixclone.models.Trailersmodel;
import com.example.netflixclone.viewmodels.Movieviewmodel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Wrapper;
import java.text.DecimalFormat;
import java.util.List;


public class Playvideofragment extends Fragment {

    TextView title,year,duration,ratings,overview;
    Moviemodel data;
    private boolean isExpanded = false;
    Movieviewmodel movieviewmodel;
     Boolean hasSeasons=false;
     WebView videoplayer;
     int noofseasonss=0;
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

        title=view.findViewById(R.id.videotitle);
        year=view.findViewById(R.id.year);
        duration=view.findViewById(R.id.duration);
        ratings=view.findViewById(R.id.ratings);
        overview=view.findViewById(R.id.overview);
        movieviewmodel = new Movieviewmodel();
        movieviewmodel= new ViewModelProvider(this).get(Movieviewmodel.class);

        videoplayer=view.findViewById(R.id.videoplayer);




overview.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onExpandableTextViewClick(view);
    }
});
        bottomNavigationView = view.findViewById(R.id.videotabs);
        bottomNavigationView.getMenu().getItem(0).setVisible(false);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);


        Log.e("#",data.getId()+"--lolol");
        movieviewmodel.fetchnofoseasons(data.getId());

        // Create a PopupMenu and inflate it with your menu resource


// Get the menu item you want to change the color for


// Set the desired text color
//        for (int i=1;i<menu.size();i++) {
//            SpannableString spannableString = new SpannableString(menu.getItem(i).getTitle());
//            spannableString.setSpan(new ForegroundColorSpan(Color.GRAY), 0, spannableString.length(), 0);
//
//            menu.getItem(i).setTitle(spannableString);
//        }




setDataforviews();


        movieviewmodel.getTrailer().observe(getViewLifecycleOwner(), new Observer<List<Trailersmodel>>() {
            @Override
            public void onChanged(List<Trailersmodel> trailersmodels) {

                if(trailersmodels!=null)
                {
                    try{
                        String key=trailersmodels.get(0).getKey();
                        configureWebView(videoplayer);
                        loadYoutubeVideo(key,videoplayer);

                    }
                    catch (Exception e){

                    }

                }
            }
        });

        movieviewmodel.fetchTrailer(data.getId());


        movieviewmodel.getDuration().observe(getViewLifecycleOwner(), new Observer<Durationmodel>() {
            @Override
            public void onChanged(Durationmodel durationmodel) {
                Log.e("#","lol  "+durationmodel.getDuration()+"");
                int totalMinutes = Integer.parseInt(durationmodel.getDuration());
                int hours = totalMinutes / 60; // Integer division, gives the number of hours
                int minutes = totalMinutes % 60;
                duration.setText(hours+"h "+minutes+"m");


            }
        });

        movieviewmodel.getNoofseasons().observe(getViewLifecycleOwner(), new Observer<Noofseasonsmodel>() {
            @Override
            public void onChanged(Noofseasonsmodel noofseasonsmodel) {
                Log.e("#","seasons  "+noofseasonsmodel.getNoofseason()+"");
               hasSeasons=true;

               noofseasonss=noofseasonsmodel.getNoofseason();
               bottomNavigationView.getMenu().getItem(0).setVisible(true);
                bottomNavigationView.getMenu().getItem(1).setChecked(false);
                bottomNavigationView.getMenu().getItem(0).setChecked(true);

                if(noofseasonss>0)
                    setFragments(0);
                else
                    setFragments(1);



            }
        });


        if(noofseasonss>0)
            setFragments(0);
        else
            setFragments(1);

        // Set up item click listener for the BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            switch (itemId){
                case R.id.episodesmenu:
                    setFragments(0);
                    item.setChecked(true);

                    break;
                case R.id.morelikethismenu:
                    setFragments(1);
                    item.setChecked(true);

                    break;
                case R.id.trailermenu:
                    setFragments(2);
                    item.setChecked(true);

            }

            return false;
        });
        return  view;
    }

    private void setDataforviews() {

        title.setText(data.getTitle());
        if(data.getTitle()==null)
            title.setText(data.getName());

        String y;
        if(data.getYear()==null)
        {
y=data.getFirstairdate().split("-")[0];
        }
        else{
            y=data.getYear().split("-")[0];
        }

        year.setText(y);
        DecimalFormat decimalFormat = new DecimalFormat("#");

        // Format the double value as a string
        String formattedValue = decimalFormat.format(data.getRatings());
     ratings.setText(formattedValue);
     overview.setText(data.getDesc());

        movieviewmodel.fetchDuration(data.getId());

    }


    public void setFragments(int i){

        FragmentManager fragmentManager=((AppCompatActivity)getActivity()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(i==0) {
            fragmentTransaction.replace(R.id.seasonscontainer, new Episodesfragment(data.getId(),noofseasonss));
        }
        else if (i==1) {
            fragmentTransaction.replace(R.id.seasonscontainer, new Morelikethisfragment(data.getGenre_ids().get(0)));

        }
        else {
            fragmentTransaction.replace(R.id.seasonscontainer, new Trailersfragment(data.getId()));
        }
//        fragmentTransaction.addToBackStack(null); // Add the transaction to the back stack if you want to navigate back
        fragmentTransaction.commit();

    }
    public void onExpandableTextViewClick(View view) {
        final TextView expandableTextView = view.findViewById(R.id.overview);



        expandableTextView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;

        // Update the layout
        expandableTextView.requestLayout();

    }


    private void configureWebView(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                // Prevent any external browser from opening when a link is clicked inside the WebView
                return false;
            }
        });
    }
    private void loadYoutubeVideo(String key,WebView webView) {
        Log.e("#",key);
        Log.e("#",key);


        String iframeHtml = "<html><head> <style>body { margin: 0; padding: 0; }</style></head><body><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/"
                + key
                + "?autoplay=1\" allowfullscreen></iframe></body></html>";
        webView.loadData(iframeHtml, "text/html", "utf-8");
    }

}