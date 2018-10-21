package com.example.fabio.moviefinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val moviesService = MovieFinderService.moviesService
        val movies = moviesService.getUpcomingMovies(0).results

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = UpcomingMoviesAdapter(this, movies)
    }
}
