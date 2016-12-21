package net.chandol.study.oop.article.model;

import lombok.AccessLevel;
import lombok.Getter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String contents;
    private String password;
    private OffsetDateTime created;
    private OffsetDateTime updated;
    @Getter(AccessLevel.NONE)
    private Boolean deleted = false;

    protected Comment() {
    }

    public Comment(Article article, String author, String contents, String password) {
        this.article = article;
        this.author = author;
        this.contents = contents;
        this.password = password;
        this.created = OffsetDateTime.now();
    }
}
