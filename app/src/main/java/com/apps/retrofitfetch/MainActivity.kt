package com.apps.retrofitfetch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.apps.retrofitfetch.adapter.MainAdapter
import com.apps.retrofitfetch.api.ApiInterface
import com.apps.retrofitfetch.api.MovieRepository
import com.apps.retrofitfetch.databinding.ActivityMainBinding
import com.apps.retrofitfetch.viewmodel.MainViewModel
import com.apps.retrofitfetch.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val apiInterface = ApiInterface.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this,
            MyViewModelFactory(MovieRepository(apiInterface)))
            .get(MainViewModel::class.java)
        binding.recyclerview.adapter = adapter
        viewModel.movieList.observe(this, Observer {
            adapter.setMovieList(it)
        })
        viewModel.errorMessage.observe(this, Observer {  })
        viewModel.getAllMovies()

    }
}