package com.apps.retrofitfetch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apps.retrofitfetch.api.MovieRepository
import com.apps.retrofitfetch.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val movieRepository: MovieRepository): ViewModel() {
    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies(){
        val response =movieRepository.getAllMovies()
        response.enqueue(object: Callback<List<Movie>>{
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
               errorMessage.postValue(t.message)
            }

        })
    }


}