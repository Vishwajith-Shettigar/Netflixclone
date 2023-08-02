package com.example.netflixclone.Apiservices;

import com.example.netflixclone.Apikey;
import com.example.netflixclone.Responses.Movieresponse;
import com.example.netflixclone.models.Durationmodel;
import com.example.netflixclone.models.Moviemodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface Movieapiservice {

    @Headers({"Authorization: Bearer "+Apikey.skey, "accept: application/json"})
    @GET("movie/now_playing")
    Call<Movieresponse> getMovieList();


    @Headers({"Authorization: Bearer "+Apikey.skey, "accept: application/json"})
    @GET("trending/all/day")
    Call<Movieresponse> getTrendingnow();

    @Headers({"Authorization: Bearer "+Apikey.skey, "accept: application/json"})
    @GET("discover/tv?api_key="+ Apikey.apikey +"&with_networks=213")
    Call<Movieresponse> getOnlyonnetflix();


    @Headers({"Authorization: Bearer "+Apikey.skey, "accept: application/json"})
    @GET(" trending/tv/day")
    Call<Movieresponse> getTvdramas();

    @Headers({"Authorization: Bearer "+Apikey.skey, "accept: application/json"})
    @GET("discover/movie?api_key="+ Apikey.apikey +"&with_genres=27")
    Call<Movieresponse> getHorrormovies();

    @Headers({"Authorization: Bearer "+Apikey.skey, "accept: application/json"})
    @GET("movie/{id}?api_key=b606cf25bdecfd350cb4d11ee5ddaec4&language=fr")
    Call<Durationmodel> getDuration(@Path("id") int id);





}
