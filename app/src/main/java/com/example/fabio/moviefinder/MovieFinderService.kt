package com.example.fabio.moviefinder

import com.example.fabio.moviefinder.tmdbService.TMDBService
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object MovieFinderService {
    private const val posterBaseUrl = "https://image.tmdb.org/t/p/w500"
    private const val baseUrl = "https://api.themoviedb.org/3/"

    private val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

    val moviesService: TMDBService = retrofit.create(TMDBService::class.java)

    /* ---------- Helper methods ---------- */

    fun getMoviePosterURLPath(moviePosterPath: String): String {
        return posterBaseUrl.plus(moviePosterPath)
    }

    fun wrapText(text: String, i: Int): String {
        return if (text.length > 62) {
            text.substring(0, 62) + "..."
        } else {
            text
        }
    }
}