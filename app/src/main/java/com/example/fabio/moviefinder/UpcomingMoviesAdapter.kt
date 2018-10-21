package com.example.fabio.moviefinder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.fabio.moviefinder.tmdbService.MovieListingModel
import com.squareup.picasso.Picasso

class UpcomingMoviesAdapter(val context: Context, val movies: List<MovieListingModel>) : RecyclerView.Adapter<UpcomingMoviesAdapter.MovieHolder>() {
    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieCardTitle: TextView = itemView.findViewById(R.id.movieCardTitle)
        val movieCardImage: ImageView = itemView.findViewById(R.id.movieCardImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMoviesAdapter.MovieHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.movie_card, parent, false)

        return MovieHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: UpcomingMoviesAdapter.MovieHolder, position: Int) {
        val movie = movies[position]
        val moviePosterPath = getMoviePosterURLPath(movie.moviePosterPath)
        val movieTitle = movie.title

        holder.movieCardTitle.text = movieTitle
        Picasso.get().load(moviePosterPath).fit().into(holder.movieCardImage)
    }

    private fun getMoviePosterURLPath(moviePosterPath: String): String {
        val posterURLBase: String = MovieFinderService.moviesService.baseUrlForImages
        return posterURLBase + moviePosterPath
    }
}