package net.chandol.study.oop.article.model;

import lombok.AccessLevel;
import lombok.Getter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import static org.hibernate.annotations.ResultCheckStyle.COUNT;

@Entity
@Getter
@SQLDelete(sql = "UPDATE Article SET deleted = true WHERE id = ?", check = COUNT)
@Where(clause = "deleted = false")
@Table(indexes = @Index(columnList = "deleted"))
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String password;
    @Column(columnDefinition = "TEXT")
    private String contents;


    @ElementCollection
    @OrderColumn(name = "TAG_SORT_ORDER")
    @CollectionTable(name = "ARTICLE_TAG")
    private List<Tag> tags;
    private OffsetDateTime created;
    private OffsetDateTime updated;
    @Getter(AccessLevel.NONE)
    private Boolean deleted = false;

    protected Article() {
    }

    public Article(String title, String author, String password, String contents, List<Tag> tags) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPassword(password);
        this.setContents(contents);
        this.setTags(tags);
        this.created = OffsetDateTime.now();
    }

    public void modify(String title, String author, String password, String body, List<Tag> tags) {
        verifyPasswordIsSame(password);
        this.setTitle(title);
        this.setAuthor(author);
        this.setContents(body);
        this.setTags(tags);
        this.updated = OffsetDateTime.now();
    }

    public List<Tag> getTags() {
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

    private void setContents(String contents) {
        this.contents = contents;
    }

    private void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    private void verifyPasswordIsSame(String password) {
        if (!this.password.equals(password)) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }

    }

}
