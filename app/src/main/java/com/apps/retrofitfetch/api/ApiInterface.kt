package com.apps.retrofitfetch.api

import com.apps.retrofitfetch.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiInterface {
    @GET("movielist.json")
    fun getAllMovies(): Call<List<Movie>>

    companion object{
        var apiInstance:ApiInterface? = null
        fun getInstance(): ApiInterface{
            if (apiInstance == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://howtodoandroid-com.ibrave.host/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


                apiInstance = retrofit.create(ApiInterface::class.java)
            }
            return apiInstance!!
        }
    }
}