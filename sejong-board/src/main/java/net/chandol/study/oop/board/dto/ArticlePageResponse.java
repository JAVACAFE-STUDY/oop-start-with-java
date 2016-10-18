package net.chandol.study.oop.board.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ArticlePageResponse {
    private Long id;
    private Long boardId;
    private String title;
    private String author;
    private OffsetDateTime created;
    private OffsetDateTime updated;
}
