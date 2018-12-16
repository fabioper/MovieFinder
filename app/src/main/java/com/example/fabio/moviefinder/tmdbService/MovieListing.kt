package com.example.fabio.moviefinder.tmdbService

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class MovieListing(
        @JsonProperty("id")
        var id: Int = 0,
        @JsonProperty("title")
        var title: String = "",
        @JsonProperty("poster_path")
        var posterPath: String? = "",
        @JsonProperty("backdrop_path")
        var backdropPath: String? = "",
        @JsonProperty("release_date")
        var releaseDate: String = "",
        @JsonProperty("overview")
        var overview: String = ""
)