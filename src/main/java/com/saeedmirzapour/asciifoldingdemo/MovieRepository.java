package com.saeedmirzapour.asciifoldingdemo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieRepository extends ElasticsearchRepository<Movie, String>, MovieRepositoryCustom {
}
