package net.chandol.study.oop.article.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdateRequest extends ArticleRequest {
    protected ArticleUpdateRequest() {
    }

    public ArticleUpdateRequest(String title, String body) {
        super(title, body);
    }
}