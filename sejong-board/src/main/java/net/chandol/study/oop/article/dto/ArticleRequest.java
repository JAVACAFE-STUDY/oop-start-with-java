package net.chandol.study.oop.article.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public abstract class ArticleRequest {
    private String title;
    private String contents;
    private String author;
    private String password;
    private List<String> tags;

    protected ArticleRequest() {
    }

    public ArticleRequest(String title, String contents, String author, String password, List<String> tags) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.password = password;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ArticleRequest{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", author='" + author + '\'' +
                ", password='" + password + '\'' +
                ", tags=" + tags +
                '}';
    }
}

