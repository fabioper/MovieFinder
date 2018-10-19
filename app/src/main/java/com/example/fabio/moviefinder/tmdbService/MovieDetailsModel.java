package com.example.fabio.moviefinder.tmdbService;

import java.util.List;

public class MovieDetailsModel {
    private Boolean adult;
    private String backdropPath;
    private Integer budget;
    private List<MovieGenreModel> genres;
    private String homepage;
    private Integer id;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private String posterPath;
    private List<ProductionCompanyModel> productionCompanies;
    private List<ProductionCountryModel> productionCountries;
    private String releaseDate;
    private Integer revenue;
    private Integer runtime;
    private List<LanguageModel> spokenLanguages;
    private String status;
    private String tagline;
    private String title;
    private Boolean video;
    private Double voteAverage;
    private Integer voteCount;

    public MovieDetailsModel(
        Boolean adult,
        String backdropPath,
        Integer budget,
        List<MovieGenreModel> genres,
        String homepage,
        Integer id,
        String imdbId,
        String originalLanguage,
        String originalTitle,
        String overview,
        Double popularity,
        String posterPath,
        List<ProductionCompanyModel> productionCompanies,
        List<ProductionCountryModel> productionCountries,
        String releaseDate,
        Integer revenue,
        Integer runtime,
        List<LanguageModel> spokenLanguages,
        String status,
        String tagline,
        String title,
        Boolean video,
        Double voteAverage,
        Integer voteCount
    ) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.budget = budget;
        this.genres = genres;
        this.homepage = homepage;
        this.id = id;
        this.imdbId = imdbId;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.productionCompanies = productionCompanies;
        this.productionCountries = productionCountries;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.runtime = runtime;
        this.spokenLanguages = spokenLanguages;
        this.status = status;
        this.tagline = tagline;
        this.title = title;
        this.video = video;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Integer getBudget() {
        return budget;
    }

    public List<MovieGenreModel> getGenres() {
        return genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public Integer getId() {
        return id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public List<ProductionCompanyModel> getProductionCompanies() {
        return productionCompanies;
    }

    public List<ProductionCountryModel> getProductionCountries() {
        return productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public List<LanguageModel> getSpokenLanguages() {
        return spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getVideo() {
        return video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }
}
