package com.example.fabio.moviefinder.tmdbService

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/upcoming?api_key=bb233427b31dced12e8df0d6cf9a4d72&language=pt-BR&page=1")
    fun getUpcomingMovies() : Call<MovieList>

    @GET("movie/{movieId}?api_key=bb233427b31dced12e8df0d6cf9a4d72&language=pt-BR")
    fun getMovieDetails(@Path("movieId") movieId: Int) : Call<MovieDetails>

    @GET("https://api.themoviedb.org/3/search/movie?api_key=bb233427b31dced12e8df0d6cf9a4d72&language=pt-BR&")
    fun searchMoviesByTitle(@Query("query") query: String) : Call<MovieList>
}