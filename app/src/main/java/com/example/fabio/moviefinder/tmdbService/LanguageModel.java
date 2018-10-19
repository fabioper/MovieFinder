package com.example.fabio.moviefinder.tmdbService;

public class LanguageModel {
    private String iso6391;
    private String name;

    public LanguageModel(String iso6391, String name) {
        this.iso6391 = iso6391;
        this.name = name;
    }

    public String getIso6391() {
        return iso6391;
    }

    public String getName() {
        return name;
    }
}
