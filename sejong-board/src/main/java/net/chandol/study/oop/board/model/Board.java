package net.chandol.study.oop.board.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Board() {
    }

    public Board(String name) {
        this.name = name;
    }
}
