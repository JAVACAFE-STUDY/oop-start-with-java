package net.chandol.study.oop.board.service;

import net.chandol.study.oop.board.dto.ArticleRequest.ArticleCreateRequest;
import net.chandol.study.oop.board.dto.BoardCreateRequest;
import net.chandol.study.oop.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SampleDataGenerator {
    @Autowired
    ArticleService articleService;
    @Autowired
    BoardService boardService;

    // 테스트 샘플 데이터 생성!!
    @PostConstruct
    public void generateSampleData() {
        Board javaBoard = boardService.createBoard(new BoardCreateRequest("JAVA"));
        Board phpBoard = boardService.createBoard(new BoardCreateRequest("PHP"));
        Board rubyBoard = boardService.createBoard(new BoardCreateRequest("RUBY"));

        for (int idx = 0; idx < 100; idx++) {
            articleService.createArticle(javaBoard, new ArticleCreateRequest("title" + idx, "body" + idx, "author" + idx));
            articleService.createArticle(phpBoard, new ArticleCreateRequest("title" + idx, "body" + idx, "author" + idx));
            articleService.createArticle(rubyBoard, new ArticleCreateRequest("title" + idx, "body" + idx, "author" + idx));
        }

    }
}
