package net.chandol.study.oop.article.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
@Getter
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String body;
    private OffsetDateTime created;
    private OffsetDateTime updated;

    public Article() {
    }

    public Article(String title, String author, String body) {
        this.title = title;
        this.author = author;
        this.body = body;
        this.created = OffsetDateTime.now();
    }

    public void modify(String title, String body){
        this.title = title;
        this.body = body;
        this.updated = OffsetDateTime.now();
    }
}
