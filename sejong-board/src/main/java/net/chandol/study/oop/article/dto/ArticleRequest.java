package net.chandol.study.oop.article.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public abstract class ArticleRequest {
    private String title;
    private String body;
    private String author;
    private String password;
    private List<String> tags;

    protected ArticleRequest() {
    }

    public ArticleRequest(String title, String body, String author, String password, List<String> tags) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.password = password;
        this.tags = tags;
    }
}

