package com.example.fabio.moviefinder.tmdbService;

import java.util.List;

public class MovieListingModel {
    private String moviePosterPath;
    private Boolean adult;
    private String overview;
    private String releaseDate;
    private List<Integer> genreIds;
    private Integer id;
    private String originalTitle;
    private String originalLanguage;
    private String title;
    private String backdropPath;
    private Double popularity;
    private Integer voteCount;
    private Boolean video;
    private Double voteAverage;

    public MovieListingModel(
        String moviePosterPath,
        Boolean adult,
        String overview,
        String releaseDate,
        List<Integer> genreIds,
        Integer id,
        String originalTitle,
        String originalLanguage,
        String title,
        String backdropPath,
        Double popularity,
        Integer voteCount,
        Boolean video,
        Double voteAverage
    ) {
        this.moviePosterPath = moviePosterPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.genreIds = genreIds;
        this.id = id;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.title = title;
        this.backdropPath = backdropPath;
        this.popularity = popularity;
        this.voteCount = voteCount;
        this.video = video;
        this.voteAverage = voteAverage;
    }

    public String getMoviePosterPath() {
        return moviePosterPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public Integer getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }
}
