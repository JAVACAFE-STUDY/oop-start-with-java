package net.chandol.study.oop.article.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleCreateRequest extends ArticleRequest {
    private String author;

    protected ArticleCreateRequest() {
    }

    public ArticleCreateRequest(String title, String body, String author) {
        super(title, body);
        this.author = author;
    }
}