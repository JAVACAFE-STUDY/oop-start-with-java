package net.chandol.study.oop.article.dto;

import lombok.Data;


@Data
public abstract class ArticleRequest {
    private String title;
    private String body;

    protected ArticleRequest() {
    }

    public ArticleRequest(String title, String body) {
        this.title = title;
        this.body = body;
    }



}

