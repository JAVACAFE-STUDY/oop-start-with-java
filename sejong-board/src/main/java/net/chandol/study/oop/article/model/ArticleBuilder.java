package net.chandol.study.oop.article.model;

import java.util.ArrayList;
import java.util.List;

public class ArticleBuilder {
    private String title;
    private String author;
    private String password;
    private String contents;
    private List<Tag> tags = new ArrayList<>();

    ArticleBuilder() {
    }

    public ArticleBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ArticleBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public ArticleBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public ArticleBuilder withContents(String contents) {
        this.contents = contents;
        return this;
    }

    public ArticleBuilder withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Article build() {
        return new Article(title, author, password, contents, tags);
    }
}
