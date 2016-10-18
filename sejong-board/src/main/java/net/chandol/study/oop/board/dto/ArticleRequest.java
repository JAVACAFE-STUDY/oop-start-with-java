package net.chandol.study.oop.board.dto;

import lombok.Data;


@Data
public abstract class ArticleRequest {
    private String title;
    private String body;

    protected ArticleRequest() {
    }

    public ArticleRequest(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Data
    public static class ArticleCreateRequest extends ArticleRequest{
        private String author;

        protected ArticleCreateRequest() {
        }

        public ArticleCreateRequest(String title, String body, String author) {
            super(title, body);
            this.author = author;
        }
    }

    @Data
    public static class ArticleUpdateRequest extends ArticleRequest{
        protected ArticleUpdateRequest() {
        }

        public ArticleUpdateRequest(String title, String body) {
            super(title, body);
        }
    }
}

