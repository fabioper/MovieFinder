package com.example.fabio.moviefinder.adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.fabio.moviefinder.MovieDetailsActivity
import com.example.fabio.moviefinder.MovieFinderService.getMoviePosterURLPath
import com.example.fabio.moviefinder.MovieFinderService.wrapText
import com.example.fabio.moviefinder.R
import com.example.fabio.moviefinder.tmdbService.MovieListing
import com.squareup.picasso.Picasso
import java.time.LocalDate

class SearchMovieRecyclerViewAdapter(private val context: Context, private val filteredMovies: ArrayList<MovieListing>)
    : RecyclerView.Adapter<SearchMovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.search_movie_results_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = filteredMovies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = filteredMovies[position]
        val movieImageUrl = movie.posterPath?.let { getMoviePosterURLPath(it) }

        holder.movieTitle.text = movie.title
        holder.movieOverview.text = wrapText(movie.overview, 62)
        holder.movieReleaseYear.text = movie.releaseDate.split("-").first()

        Picasso.get()
                .load(movieImageUrl)
                .into(holder.movieImage)

        // Set on click listener
        holder.movieCard.setOnClickListener {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.putExtra("movieId", movie.id)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle: TextView = itemView.findViewById(R.id.movieSearchItemTitle)
        val movieImage: ImageView = itemView.findViewById(R.id.movieSearchItemImage)
        val movieReleaseYear: TextView = itemView.findViewById(R.id.movieSearchReleaseYear)
        val movieOverview: TextView = itemView.findViewById(R.id.movieSearchItemOverview)
        val movieCard: CardView = itemView.findViewById(R.id.movieSearchCard)
    }
}
