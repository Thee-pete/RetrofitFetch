package com.apps.retrofitfetch.api

class MovieRepository(val apiInterface: ApiInterface) {

    fun getAllMovies()= apiInterface.getAllMovies()
}