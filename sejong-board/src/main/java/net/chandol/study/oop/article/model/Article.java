package net.chandol.study.oop.article.model;

import lombok.Getter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String password;

    @Column(columnDefinition = "TEXT")
    private String body;

    @ElementCollection
    @OrderColumn(name = "TAG_SORT_ORDER")
    @CollectionTable(name = "ARTICLE_TAG")
    private List<Tag> tags;

    private OffsetDateTime created;
    private OffsetDateTime updated;

    protected Article() {
    }

    public Article(String title, String author, String password, String body, List<Tag> tags) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPassword(password);
        this.setBody(body);
        this.setTags(tags);
        this.created = OffsetDateTime.now();
    }

    public void modify(String title, String author, String password, String body, List<Tag> tags) {
        verifyPasswordIsSame(password);
        this.setTitle(title);
        this.setAuthor(author);
        this.setBody(body);
        this.setTags(tags);
        this.updated = OffsetDateTime.now();
    }

    public List<Tag> getTags(){
        return Collections.unmodifiableList(this.tags);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setBody(String body) {
        this.body = body;
    }

    private void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    private void verifyPasswordIsSame(String password) {
        if(password.equals(this.password)){
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
    }

}
