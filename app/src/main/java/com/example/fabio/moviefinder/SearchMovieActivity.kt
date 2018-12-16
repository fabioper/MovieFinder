package com.example.fabio.moviefinder

import android.app.SearchManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.fabio.moviefinder.adapters.SearchMovieRecyclerViewAdapter
import com.example.fabio.moviefinder.tmdbService.MovieList
import kotlinx.android.synthetic.main.activity_search_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchMovieActivity : AppCompatActivity() {
    private val TAG = "SearchMovieActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        progressBar.visibility = View.VISIBLE

        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also(this::searchMovies)
        }
    }

    private fun searchMovies(query: String) {
        val call = MovieFinderService.moviesService.searchMoviesByTitle(query)

        Log.d(TAG, "onCreate: search movies...")

        call.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Log.d(TAG, "onFailure: failed to search the movies: error: ${t.localizedMessage}")
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                Log.d(TAG, "onResponse: finished searching movies: found: ${response.body()?.totalResults}")
                if (response.isSuccessful) {
                    progressBar.visibility = View.GONE
                    val moviesFound = response.body()!!.results
                    searchMovieRecyclerView.layoutManager =
                            LinearLayoutManager(this@SearchMovieActivity, LinearLayoutManager.VERTICAL, false)
                    searchMovieRecyclerView.adapter =
                            SearchMovieRecyclerViewAdapter(this@SearchMovieActivity, moviesFound)
                }
            }
        })
    }
}
