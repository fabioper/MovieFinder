package com.example.fabio.moviefinder

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.fabio.moviefinder.MovieFinderService.getMoviePosterURLPath
import com.example.fabio.moviefinder.tmdbService.MovieDetails
import com.like.LikeButton
import com.like.OnLikeListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

class MovieDetailsActivity : AppCompatActivity() {
    private val TAG = "MovieDetailsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        progressBar.visibility = View.VISIBLE

        val moviesService = MovieFinderService.moviesService
        val movieId = intent.extras?.getInt("movieId")!!

        val call = moviesService.getMovieDetails(movieId)
        Log.d(TAG, "onCreate: retrieving movie details...")

        call.enqueue(object : Callback<MovieDetails> {
            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                Log.d(TAG, "onFailure: failed to retrieve movie details: error: ${t.localizedMessage}")
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<MovieDetails>, response: Response<MovieDetails>) {
                Log.d(TAG, "onResponse: finished retrieving ${response.body()?.title} movie details")
                if (response.isSuccessful) {
                    progressBar.visibility = View.GONE
                    val movie = response.body()!!
                    renderUI(movie)
                }
            }
        })

        addToFavoritesButton.setOnLikeListener(object : OnLikeListener {
            override fun liked(likeButton: LikeButton?) {
                favoriteMovie(movieId)
            }

            override fun unLiked(likeButton: LikeButton?) {
                unfavoriteMovie(movieId)
            }
        })
    }

    private fun renderUI(movie: MovieDetails) {
        val movieImage = movie.backdropPath?.let { getMoviePosterURLPath(it) }

        movieDetailsTitle.text = movie.title
        movieDetailsOverviewText.text = movie.overview
        addToFavoritesButton.isLiked = MovieFinderService.favorites.contains(movie.id)
        ratingBar.rating = ((5 / movie.popularity) * 100).toFloat()
        movieDetailsReleaseYear.text = movie.releaseDate.split("-").first()

        // Assign movie image to ImageView
        Picasso.get()
            .load(movieImage)
            .fit()
            .into(movieDetailsImage)
    }

    private fun favoriteMovie(movieId: Int) {
        AddToFavorites(this@MovieDetailsActivity, progressBar).execute(movieId)
    }

    private fun unfavoriteMovie(movieId: Int) {
        RemoveFromFavorites(this@MovieDetailsActivity, progressBar).execute(movieId)
    }
}
