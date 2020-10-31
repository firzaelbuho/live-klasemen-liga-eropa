package com.proximastudio.bola.repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository {

    fun create(): ApiServices {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.thesportsdb.com/")
                .build()
        return retrofit.create(ApiServices::class.java)
    }

}