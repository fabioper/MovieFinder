package com.example.fabio.moviefinder.tmdbService;

public class ProductionCompanyModel {
    private String name;
    private Integer id;
    private String logoPath;
    private String originCountry;

    public ProductionCompanyModel(String name, Integer id, String logoPath, String originCountry) {
        this.name = name;
        this.id = id;
        this.logoPath = logoPath;
        this.originCountry = originCountry;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public String getOriginCountry() {
        return originCountry;
    }
}
