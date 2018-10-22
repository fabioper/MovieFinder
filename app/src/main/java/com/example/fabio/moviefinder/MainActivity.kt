package com.example.fabio.moviefinder

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get TMDBService object instance
        val moviesService = MovieFinderService.moviesService

        // Get upcoming movies from TMDBService
        val movies = moviesService.getUpcomingMovies(0).results

        // Set up RecyclerView
        // Define the RecyclerView layout manager as a GridLayout with a span of 2
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Assign the RecyclerView adapter
        recyclerView.adapter = UpcomingMoviesAdapter(this, movies)

        // Set up FAB click listener to move to Search Movie activity
        floatingActionButton.setOnClickListener {
            val intent = Intent(this, SearchMovie::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
