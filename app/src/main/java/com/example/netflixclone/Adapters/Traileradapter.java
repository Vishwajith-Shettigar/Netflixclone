package com.example.netflixclone.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netflixclone.R;
import com.example.netflixclone.models.Trailersmodel;


import java.util.List;

public class Traileradapter extends RecyclerView.Adapter<Traileradapter.Myviewholder> {

    List<Trailersmodel>data;
    Context context;

    public Traileradapter(Context context, List<Trailersmodel> data) {
       this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.trailervideolayout,parent,false);
       return new Myviewholder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

        String videoUrl="https://www.youtube.com/watch?v="+data.get(position).getKey();
        Log.e("#",videoUrl);


        WebView webView=holder.videoView;

        loadYoutubeVideo(data.get(position).getKey(),webView);




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


        String iframeHtml = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/"
                + key
                + "?autoplay=1\" frameborder=\"0\" allowfullscreen></iframe></body></html>";
        webView.loadData(iframeHtml, "text/html", "utf-8");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{

WebView videoView;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            videoView=itemView.findViewById(R.id.tlvideoplayer);
            configureWebView(videoView);

        }
    }
}
