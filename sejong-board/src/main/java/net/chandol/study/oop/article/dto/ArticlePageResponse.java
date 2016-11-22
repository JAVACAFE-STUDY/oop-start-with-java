package net.chandol.study.oop.article.dto;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class ArticlePageResponse {
    private Long id;
    private String title;
    private String author;
    private List<String> tags;
    private OffsetDateTime created;
    private OffsetDateTime updated;
}
