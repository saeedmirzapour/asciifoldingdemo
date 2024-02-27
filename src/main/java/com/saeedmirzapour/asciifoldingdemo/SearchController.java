package com.saeedmirzapour.asciifoldingdemo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private final MovieRepository movieRepository;

    public SearchController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/api/movies")
    public Page<Movie> handle(@RequestParam String title, Pageable pageable) {
        return movieRepository.search(title, pageable);
    }
}
