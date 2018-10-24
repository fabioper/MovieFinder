package com.example.fabio.moviefinder

import android.app.SearchManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast

class SearchMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_movie)

        if (Intent.ACTION_SEARCH == intent.action) {
            intent.getStringExtra(SearchManager.QUERY)?.also(this::searchMovies)
        }
    }

    private fun searchMovies(query: String) {
        Toast.makeText(this, query, Toast.LENGTH_LONG).show()
    }
}
