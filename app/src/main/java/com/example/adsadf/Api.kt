package com.example.adsadf

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @get:GET("forces")
    val forces: Call<List<Forces>>

    companion object {
        const val BASE_URL = "https://data.police.uk/api/"
    }
}
