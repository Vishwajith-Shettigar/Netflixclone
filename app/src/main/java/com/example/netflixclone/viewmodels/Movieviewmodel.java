package com.example.netflixclone.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.netflixclone.Apiservices.Durationresponse;
import com.example.netflixclone.Apiservices.Movieapiservice;
import com.example.netflixclone.Responses.Episodesresponse;
import com.example.netflixclone.Responses.Movieresponse;
import com.example.netflixclone.Responses.Tarilerresponse;
import com.example.netflixclone.models.Durationmodel;
import com.example.netflixclone.models.Episodemodel;
import com.example.netflixclone.models.Moviemodel;
import com.example.netflixclone.models.Noofseasonsmodel;
import com.example.netflixclone.models.Seasonsmodel;
import com.example.netflixclone.models.Trailersmodel;

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

    private MutableLiveData <List<Episodemodel>> episodedata = new MutableLiveData<>();
    private MutableLiveData<Durationmodel>durationdata = new MutableLiveData<>();

    private MutableLiveData<Noofseasonsmodel>noofseasondata = new MutableLiveData<>();

    private MutableLiveData<List<Moviemodel>> morelikethisdata = new MutableLiveData<>();

    private MutableLiveData<List<Trailersmodel>> trailerdata = new MutableLiveData<>();

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
    public LiveData<Durationmodel> getDuration() {
        return durationdata;
    }



    public LiveData<List<Episodemodel>> getEpisode() {
        return episodedata;
    }
    public LiveData<Noofseasonsmodel> getNoofseasons() {
        return noofseasondata;
    }

    public LiveData<List<Moviemodel>> getMorelikethis() {
        return morelikethisdata;
    }

    public LiveData<List<Trailersmodel>> getTrailer() {
        return trailerdata;
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

    public void fetchDuration(int id) {
        Log.e("#", "fecth daat");
        Call<Durationmodel> call = movieapiservice.getDuration(id);
        call.enqueue(new Callback<Durationmodel>() {

            public void onResponse(Call<Durationmodel> call, Response<Durationmodel> response) {
                if (response.isSuccessful()) {

                    Durationmodel dataList =response.body();

                    Log.e("#","under res"+ dataList.getDuration());
                    durationdata.postValue(dataList);

                }
                else{

                    Log.e("#","under nosuces");
                }
            }



            @Override
            public void onFailure(Call<Durationmodel> call, Throwable t) {
                Log.e("#","under failure");
            }

        });
    }


    public void fetchEpisodes(int id) {

        Log.e("#", "fecth daat");
        Call<Episodesresponse> call = movieapiservice.getEpisodes();
        call.enqueue(new Callback<Episodesresponse>() {

            public void onResponse(Call<Episodesresponse> call, Response<Episodesresponse> response) {
                if (response.isSuccessful()) {
                    Episodesresponse data =  response.body();
                    List<Episodemodel> dataList = data.getEpisodesmodel();

//                    Log.e("#"," fetching episode -->"+  dataList.get(0).getOverview());
                    episodedata.postValue(dataList);

                }
            }



            @Override
            public void onFailure(Call<Episodesresponse> call, Throwable t) {

            }

        });
    }


    public void fetchnofoseasons(int id) {
        Log.e("#", "fecth daat");
        Call<Noofseasonsmodel> call = movieapiservice.getNofseasons(id);
        call.enqueue(new Callback<Noofseasonsmodel>() {

            public void onResponse(Call<Noofseasonsmodel> call, Response<Noofseasonsmodel> response) {
                if (response.isSuccessful()) {

                    Noofseasonsmodel dataList =response.body();

                    Log.e("#","under res"+ dataList.getNoofseason());
                    noofseasondata.postValue(dataList);

                }
                else{

                    Log.e("#","under nosuces");
                }
            }



            @Override
            public void onFailure(Call<Noofseasonsmodel> call, Throwable t) {
                Log.e("#","under failure");
            }

        });
    }



    public void fetchMorelikethis(int genreid) {
        Log.e("#", "fecth daat");
        Call<Movieresponse> call = movieapiservice.getMorelikethis(genreid);
        call.enqueue(new Callback<Movieresponse>() {

            public void onResponse(Call<Movieresponse> call, Response<Movieresponse> response) {
                if (response.isSuccessful()) {
                    Movieresponse data =  response.body();
                    List<Moviemodel> dataList = data.getResults();
                    morelikethisdata.postValue(dataList);

                }
            }



            @Override
            public void onFailure(Call<Movieresponse> call, Throwable t) {

            }

        });
    }

    public void fetchTrailer(int id) {
        Log.e("#", "fecth daat");
        Call<Tarilerresponse> call = movieapiservice.getTrailer(id);
        call.enqueue(new Callback<Tarilerresponse>() {

            public void onResponse(Call<Tarilerresponse> call, Response<Tarilerresponse> response) {
                if (response.isSuccessful()) {
                    Tarilerresponse data =  response.body();
                    List<Trailersmodel> dataList = data.getTrailersmodels();
                    trailerdata.postValue(dataList);

                }
            }



            @Override
            public void onFailure(Call<Tarilerresponse> call, Throwable t) {

            }

        });
    }


}

