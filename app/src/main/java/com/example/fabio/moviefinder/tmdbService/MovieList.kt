package com.example.fabio.moviefinder.tmdbService

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class MovieList(
        @JsonProperty("results")
        var results: ArrayList<MovieListing> = ArrayList(),
        @JsonProperty("total_results")
        var totalResults: Number = 0
)
