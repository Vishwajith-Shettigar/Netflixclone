package com.example.netflixclone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.netflixclone.Fragmentsnetflix.Playvideofragment;
import com.example.netflixclone.R;
import com.example.netflixclone.models.Moviemodel;

import java.util.List;

public class Moviesadapter extends RecyclerView.Adapter<Moviesadapter.Myviewholder> {
private List<Moviemodel> datalist;
Context context;

public Moviesadapter(Context context,List<Moviemodel> datalist)
{
    this.datalist=datalist;
    this.context=context;
}

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hosrizonlayer, parent, false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder,  int position) {

    Moviemodel data=datalist.get(position);
    final  int p=position;

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+data.getImage()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playvideo(p);
            }
        });

    }

    private void playvideo(int position) {
     Moviemodel data=datalist.get(position);

        FragmentManager fragmentManager=((AppCompatActivity)context).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framecontainer, new Playvideofragment(data));
        fragmentTransaction.addToBackStack(null); // Add the transaction to the back stack if you want to navigate back
        fragmentTransaction.commit();
    }


    @Override
    public int getItemCount() {
        return datalist.size();
    }

    static class Myviewholder extends RecyclerView.ViewHolder{

ImageView imageView;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.horimage);
        }
    }
}


