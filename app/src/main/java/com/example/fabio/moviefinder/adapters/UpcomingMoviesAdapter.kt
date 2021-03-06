package com.example.fabio.moviefinder.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.fabio.moviefinder.MovieDetailsActivity
import com.example.fabio.moviefinder.MovieFinderService.getMoviePosterURLPath
import com.example.fabio.moviefinder.R
import com.example.fabio.moviefinder.tmdbService.MovieListing
import com.squareup.picasso.Picasso

class UpcomingMoviesAdapter(val context: Context, val movies: ArrayList<MovieListing>) : RecyclerView.Adapter<UpcomingMoviesAdapter.MovieHolder>() {
    class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieCardTitle: TextView = itemView.findViewById(R.id.movieCardTitle)
        val movieCardImage: ImageView = itemView.findViewById(R.id.movieCardImage)
        val movieCardView: CardView = itemView.findViewById(R.id.movieCard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.movie_card, parent, false)

        return MovieHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movies[position]
        val movieTitle = movie.title
        val moviePosterPath = movie.posterPath?.let { getMoviePosterURLPath(it) }

        holder.movieCardTitle.text = movieTitle
        Picasso.get().load(moviePosterPath).fit().into(holder.movieCardImage)

        // Add Click Event Listener
        holder.movieCardView.setOnClickListener {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra("movieId", movie.id)
            context.startActivity(intent)
        }
    }
}