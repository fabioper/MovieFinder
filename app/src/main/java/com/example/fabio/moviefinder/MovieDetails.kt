package com.example.fabio.moviefinder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val moviesService = MovieFinderService.moviesService
        val movieId = intent.extras?.getInt("movieId")
        val movie = moviesService.getMovieDetails(movieId)
        val movieTitle = movie.title
        val movieOverview = movie.overview
        val movieReleaseYear = movie.releaseDate.split('-')[0]
        val movieImage = MovieFinderService.getMoviePosterURLPath(movie.backdropPath)

        // Assign movie title
        movieDetailsTitle.text = movieTitle

        // Assign movie overview text
        movieDetailsOverviewText.text = movieOverview

        // Assign movie release year
        movieDetailsReleaseYear.text = movieReleaseYear

        // Assign movie image to ImageView
        Picasso.get().load(movieImage).fit().error(R.drawable.ic_launcher_background).into(movieDetailsImage)
    }
}
