package com.example.sevenwindsstudiotesttask.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retroInstance {

    companion object{
        val BASE_URL = "http://147.78.66.203:3210/"
    }

    fun getRetroInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}