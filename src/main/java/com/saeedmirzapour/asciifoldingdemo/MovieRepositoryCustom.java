package com.saeedmirzapour.asciifoldingdemo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieRepositoryCustom {

    Page<Movie> search(String title, Pageable pageable);
}
