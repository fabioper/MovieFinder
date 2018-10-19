package com.example.fabio.moviefinder.tmdbService;

public class ProductionCountryModel {
    private String iso31661;
    private String name;

    public ProductionCountryModel(String iso31661, String name) {
        this.iso31661 = iso31661;
        this.name = name;
    }

    public String getIso31661() {
        return iso31661;
    }

    public String getName() {
        return name;
    }
}
