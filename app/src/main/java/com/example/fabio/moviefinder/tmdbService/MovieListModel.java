package com.example.fabio.moviefinder.tmdbService;

import java.util.List;

public class MovieListModel {
    private Integer page;
    private List<MovieListingModel> results;
    private Integer totalPages;
    private Integer totalResults;

    public MovieListModel(
        Integer page,
        List<MovieListingModel> results,
        Integer totalPages,
        Integer totalResults
    ) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public Integer getPage() {
        return page;
    }

    public List<MovieListingModel> getResults() {
        return results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }
}
