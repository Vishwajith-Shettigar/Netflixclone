package com.example.netflixclone.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.netflixclone.Apiservices.Movieapiservice;
import com.example.netflixclone.Responses.Movieresponse;
import com.example.netflixclone.models.Moviemodel;

import java.text.Collator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Movieviewmodel extends ViewModel {

    Retrofit retrofit;
    private MutableLiveData<List<Moviemodel>> moviedata = new MutableLiveData<>();
    private MutableLiveData<List<Moviemodel>> trendingnowdata = new MutableLiveData<>();


    private MutableLiveData<List<Moviemodel>> onlyonnetflixdata = new MutableLiveData<>();

    private MutableLiveData<List<Moviemodel>> tvdramasdata = new MutableLiveData<>();

    private MutableLiveData<List<Moviemodel>> horrormoviesdata = new MutableLiveData<>();
    private Movieapiservice movieapiservice;

    public Movieviewmodel() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        movieapiservice = retrofit.create(Movieapiservice.class);
    }

    public LiveData<List<Moviemodel>> getMymovies() {
        return moviedata;
    }
    public LiveData<List<Moviemodel>> getTrendingnow() {
        return trendingnowdata;
    }
    public LiveData<List<Moviemodel>> getOnlyonnetflix() {
        return onlyonnetflixdata;
    }
    public LiveData<List<Moviemodel>> getTvdramas() {
        return tvdramasdata;
    }
    public LiveData<List<Moviemodel>> getHorrormovies() {
        return horrormoviesdata;
    }

    public void fetchPopularmovies() {
        Log.e("#", "fecth daat");
        Call<Movieresponse> call = movieapiservice.getMovieList();
        call.enqueue(new Callback<Movieresponse>() {

            public void onResponse(Call<Movieresponse> call, Response<Movieresponse> response) {
                if (response.isSuccessful()) {
                    Movieresponse data =  response.body();
                    List<Moviemodel> dataList = data.getResults();
                    moviedata.postValue(dataList);

                }
            }



            @Override
            public void onFailure(Call<Movieresponse> call, Throwable t) {

            }

        });
    }


    public void fetchTrendingnow() {
        Log.e("#", "fecth daat");
        Call<Movieresponse> call = movieapiservice.getTrendingnow();
        call.enqueue(new Callback<Movieresponse>() {

            public void onResponse(Call<Movieresponse> call, Response<Movieresponse> response) {
                if (response.isSuccessful()) {
                    Movieresponse data =  response.body();
                    List<Moviemodel> dataList = data.getResults();
                    trendingnowdata.postValue(dataList);

                }
            }



            @Override
            public void onFailure(Call<Movieresponse> call, Throwable t) {

            }

        });
    }


    public void fetchOnlyonnetflix() {
        Log.e("#", "fecth daat");
        Call<Movieresponse> call = movieapiservice.getOnlyonnetflix();
        call.enqueue(new Callback<Movieresponse>() {

            public void onResponse(Call<Movieresponse> call, Response<Movieresponse> response) {
                if (response.isSuccessful()) {
                    Movieresponse data =  response.body();
                    List<Moviemodel> dataList = data.getResults();
                    onlyonnetflixdata.postValue(dataList);

                }
            }



            @Override
            public void onFailure(Call<Movieresponse> call, Throwable t) {

            }

        });
    }
    public void fetchTvdramas() {
        Log.e("#", "fecth daat");
        Call<Movieresponse> call = movieapiservice.getTvdramas();
        call.enqueue(new Callback<Movieresponse>() {

            public void onResponse(Call<Movieresponse> call, Response<Movieresponse> response) {
                if (response.isSuccessful()) {
                    Movieresponse data =  response.body();
                    List<Moviemodel> dataList = data.getResults();
                    tvdramasdata.postValue(dataList);

                }
            }



            @Override
            public void onFailure(Call<Movieresponse> call, Throwable t) {

            }

        });
    }
    public void fetchHorrormovies() {
        Log.e("#", "fecth daat");
        Call<Movieresponse> call = movieapiservice.getHorrormovies();
        call.enqueue(new Callback<Movieresponse>() {

            public void onResponse(Call<Movieresponse> call, Response<Movieresponse> response) {
                if (response.isSuccessful()) {
                    Movieresponse data =  response.body();
                    List<Moviemodel> dataList = data.getResults();
                    horrormoviesdata.postValue(dataList);

                }
            }



            @Override
            public void onFailure(Call<Movieresponse> call, Throwable t) {

            }

        });
    }
    }

