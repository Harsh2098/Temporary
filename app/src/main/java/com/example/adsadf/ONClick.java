package com.example.adsadf;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ONClick {

    String Get="";

    String BaseUrl="https://data.police.uk/api/forces/";

    @GET(Get)
    Call<List<SpecialForce>> getSpecialForce();

}
