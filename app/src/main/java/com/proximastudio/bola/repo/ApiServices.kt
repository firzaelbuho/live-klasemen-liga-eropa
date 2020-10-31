package com.proximastudio.bola.repo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("api/v1/json/1/lookupteam.php")
    //@GET("api/v1/json/1/lookup_all_teams.php?id=4328")

    // annotation query will create like ?id=idValue in end of url

    fun getTeam(@Query("id") id: String?): Call<PostModel>

    @GET("api/v1/json/1/lookuptable.php")

    fun getStanding(@Query("l") l: String?,@Query("s") s: String? = "2020-2021" ): Call<StandingModel>

}