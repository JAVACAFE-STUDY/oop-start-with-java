package net.chandol.study.oop.board.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Article {
    private Long id;
    private Board board;
    private User user;
    private String title;
    private String body;
    private Date created;
    private Date updated;
}
