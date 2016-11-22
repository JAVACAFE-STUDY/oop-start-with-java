package net.chandol.study.oop.article.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArticleCreateRequest extends ArticleRequest {

    public ArticleCreateRequest(String title, String body, String author, String password, List<String> tags) {
        super(title, body, author, password, tags);
    }
}