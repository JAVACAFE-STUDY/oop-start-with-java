package net.chandol.study.oop.article.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ArticleModifyRequest extends ArticleRequest {

    public ArticleModifyRequest() {
    }

    public ArticleModifyRequest(String title, String contents, String author, String password, List<String> tags) {
        super(title, contents, author, password, tags);
    }
}