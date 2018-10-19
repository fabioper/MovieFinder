package com.example.fabio.moviefinder.tmdbService;

public class MovieGenreModel {
    private Integer id;
    private String name;

    public MovieGenreModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
