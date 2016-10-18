package net.chandol.study.oop.board.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.OffsetDateTime;

@Entity
@Getter
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(optional = false)
    private Board board;
    private String title;
    private String author;
    private String body;

    private OffsetDateTime created;
    private OffsetDateTime updated;

    public Article() {
    }

    public Article(Board board, String title, String author, String body) {
        this.board = board;
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

    public void changeBoard(Board board){
        this.board = board;
    }

}
