package net.chandol.study.oop.board;

import net.chandol.study.oop.board.dto.ArticlePageResponse;
import net.chandol.study.oop.board.dto.ArticleRequest;
import net.chandol.study.oop.board.dto.ArticleRequest.ArticleCreateRequest;
import net.chandol.study.oop.board.dto.BoardCreateRequest;
import net.chandol.study.oop.board.model.Article;
import net.chandol.study.oop.board.model.Board;
import net.chandol.study.oop.board.service.ArticleService;
import net.chandol.study.oop.board.service.BoardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    ArticleService articleService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/board")
    public ResponseEntity<Board> createBoard(
            @RequestBody BoardCreateRequest request) {

        Board board = boardService.createBoard(request);
        return ResponseEntity.ok(board);
    }

    @PostMapping("/board/{boardId}")
    public ResponseEntity<Board> getBoard(
            @PathVariable("boardId") Board board) {

        return ResponseEntity.ok(board);
    }

    @PostMapping("/board/{boardId}/article")
    public ResponseEntity<Article> createArticle(
            @PathVariable("boardId") Board board,
            @RequestBody ArticleCreateRequest request) {

        Article article = articleService.createArticle(board, request);
        return ResponseEntity.ok(article);
    }

    @GetMapping("/board/{boardId}/article")
    public ResponseEntity<Page<ArticlePageResponse>> pageableArticle(
            @PathVariable("boardId") Board board,
            @RequestParam(defaultValue = "0") int page) {

        Pageable pageable = new PageRequest(page, 10);
        Page<Article> articlePage = articleService.getArticlePage(board, pageable);
        Page<ArticlePageResponse> articlePageResponses = articlePage.map(article -> modelMapper.map(article, ArticlePageResponse.class));
        return ResponseEntity.ok(articlePageResponses);
    }

    @GetMapping("/board/{boardId}/article/{articleId}")
    public ResponseEntity<Article> getArticle(
            @PathVariable("boardId") Board board,
            @PathVariable("articleId") Article article) {

        return ResponseEntity.ok(article);
    }

    @PutMapping("/board/{boardId}/article/{articleId}")
    public ResponseEntity<Article> modifyArticle(
            @PathVariable("boardId") Board board,
            @PathVariable("articleId") Article article,
            ArticleRequest.ArticleUpdateRequest request) {

        Article modifiedArticle = articleService.modifyArticle(article, request);

        return ResponseEntity.ok(modifiedArticle);
    }

}
