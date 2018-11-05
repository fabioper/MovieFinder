package com.example.fabio.moviefinder

import com.example.fabio.moviefinder.tmdbService.FakeTMDBService
import com.example.fabio.moviefinder.tmdbService.MovieListingModel
import com.example.fabio.moviefinder.tmdbService.TMDBService

object MovieFinderService {
    val moviesService: TMDBService = FakeTMDBService()
    val getUpcomingMovies: MutableList<MovieListingModel> = moviesService.getUpcomingMovies(0).results

    fun getMoviePosterURLPath(moviePosterPath: String): String {
        val posterURLBase: String = MovieFinderService.moviesService.baseUrlForImages
        return posterURLBase + moviePosterPath
    }

    fun filterMovies(query: String): List<MovieListingModel> {
        return moviesService
                .getUpcomingMovies(0)
                .results
                .filter { it.title.contains(query, true) }
    }
}