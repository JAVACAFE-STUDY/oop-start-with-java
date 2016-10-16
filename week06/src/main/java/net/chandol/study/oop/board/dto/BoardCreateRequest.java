package net.chandol.study.oop.board.dto;

import lombok.Data;

@Data
public class BoardCreateRequest {
    private String name;

    protected BoardCreateRequest() {}

    public BoardCreateRequest(String name) {
        this.name = name;
    }
}
