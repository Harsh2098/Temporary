package com.example.adsadf;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BaseUrl="https://data.police.uk/api/";

    @GET("forces")
    Call<List<Forces>> getForces();
}
