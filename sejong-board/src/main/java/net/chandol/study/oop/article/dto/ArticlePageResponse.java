package net.chandol.study.oop.article.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ArticlePageResponse {
    private Long id;
    private String title;
    private String author;
    private OffsetDateTime created;
    private OffsetDateTime updated;
}
