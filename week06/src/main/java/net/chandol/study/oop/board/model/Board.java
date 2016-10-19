package net.chandol.study.oop.board.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Board {
    private Long id;
    private String name;
    private Date created;
}
