package net.chandol.study.oop.board.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Board {
    private Long id;
    private String name;
    private Date created;

    public Board(String name, Date created) {
        this.name = name;
        this.created = created;
    }
}
