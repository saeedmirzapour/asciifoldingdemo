package com.saeedmirzapour.asciifoldingdemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "movie")
@Mapping(mappingPath = "elastic/movie-mapping.json")
@Setting(settingPath = "elastic/movie-setting.json")
public class Movie {

    @Id
    private String id;
    private String title;

    public String getId() {
        return id;
    }

    public Movie setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }
}
