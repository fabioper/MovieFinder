package com.example.fabio.moviefinder

import com.example.fabio.moviefinder.tmdbService.FakeTMDBService
import com.example.fabio.moviefinder.tmdbService.TMDBService

object MovieFinderService {
    val moviesService: TMDBService = FakeTMDBService()

    fun getMoviePosterURLPath(moviePosterPath: String): String {
        val posterURLBase: String = MovieFinderService.moviesService.baseUrlForImages
        return posterURLBase + moviePosterPath
    }
}