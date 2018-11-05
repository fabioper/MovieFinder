package com.example.fabio.moviefinder

import android.app.SearchManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search_movie.*

class SearchMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also(this::searchMovies)
        }
    }

    private fun searchMovies(query: String) {
        val filteredMovies = MovieFinderService.filterMovies(query)

        searchMovieRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        searchMovieRecyclerView.adapter = SearchMovieRecyclerViewAdapter(this, filteredMovies)
    }
}
