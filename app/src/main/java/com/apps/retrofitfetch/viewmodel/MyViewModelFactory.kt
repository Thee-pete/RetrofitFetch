package com.apps.retrofitfetch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.retrofitfetch.api.MovieRepository

class MyViewModelFactory constructor(private  val movieRepository: MovieRepository):
ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.movieRepository) as T
        }else{
            throw java.lang.IllegalArgumentException("ViewModel Not Found")
        }
    }
}