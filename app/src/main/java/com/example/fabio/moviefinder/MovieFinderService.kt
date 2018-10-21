package com.example.fabio.moviefinder

import com.example.fabio.moviefinder.tmdbService.FakeTMDBService
import com.example.fabio.moviefinder.tmdbService.TMDBService

object MovieFinderService {
    val moviesService: TMDBService = FakeTMDBService()
}