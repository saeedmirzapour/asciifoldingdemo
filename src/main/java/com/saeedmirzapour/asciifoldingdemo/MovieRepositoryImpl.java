package com.saeedmirzapour.asciifoldingdemo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.stream.Collectors;

public class MovieRepositoryImpl implements MovieRepositoryCustom {

    private final ElasticsearchOperations elasticsearch;

    public MovieRepositoryImpl(ElasticsearchOperations elasticsearch) {
        this.elasticsearch = elasticsearch;
    }

    public Page<Movie> search(String title, Pageable pageable) {
        Criteria criteria = new Criteria("title").is(title);
        Query searchQuery = new CriteriaQuery(criteria);
        SearchHits<Movie> searchHits = elasticsearch.search(searchQuery, Movie.class);
        return PageableExecutionUtils.getPage(
                searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList()),
                pageable,
                searchHits::getTotalHits);
    }


}
