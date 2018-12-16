package com.example.fabio.moviefinder

import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.View
import com.example.fabio.moviefinder.adapters.UpcomingMoviesAdapter
import com.example.fabio.moviefinder.tmdbService.MovieList
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val call = MovieFinderService.moviesService.getUpcomingMovies()
        Log.d(TAG, "onCreate: retrieving upcoming movies...")
        progressBar.visibility = View.VISIBLE

        call.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Log.d(TAG, "onFailure: failed to retrieve upcoming movies: error: ${t.localizedMessage}")
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                Log.d(TAG, "onResponse: finished retrieving movies: total found: ${response.body()?.totalResults}")
                val movies = response.body()!!.results
                recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
                recyclerView.adapter = UpcomingMoviesAdapter(this@MainActivity, movies)
                progressBar.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.searchAction).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setIconifiedByDefault(false)
        }

        return true
    }
}
