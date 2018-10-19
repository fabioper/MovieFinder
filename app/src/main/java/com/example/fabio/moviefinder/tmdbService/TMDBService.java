package com.example.fabio.moviefinder.tmdbService;

public interface TMDBService {
    String getBaseUrlForImages();

    MovieListModel getUpcomingMovies(Integer page);

    MovieDetailsModel getMovieDetails(Integer movieId);

    MovieListModel searchMoviesByTitle(String query);
}
