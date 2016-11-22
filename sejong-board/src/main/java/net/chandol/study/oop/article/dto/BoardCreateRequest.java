package net.chandol.study.oop.article.dto;

import lombok.Data;

@Data
public class BoardCreateRequest {
    private String author;

    protected BoardCreateRequest() {}

    public BoardCreateRequest(String author) {
        this.author = author;
    }
}
