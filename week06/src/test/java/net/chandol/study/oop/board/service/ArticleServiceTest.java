package net.chandol.study.oop.board.service;

import net.chandol.study.oop.board.dto.ArticleRequest.ArticleCreateRequest;
import net.chandol.study.oop.board.dto.ArticleRequest.ArticleUpdateRequest;
import net.chandol.study.oop.board.dto.BoardCreateRequest;
import net.chandol.study.oop.board.model.Article;
import net.chandol.study.oop.board.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    BoardService boardService;
    @Autowired
    ArticleService articleService;

    @Test
    public void createArticle() throws Exception {
        //given
        Board board = boardService.createBoard(new BoardCreateRequest("Java"));
        ArticleCreateRequest request1 = new ArticleCreateRequest("타이틀1", "본문1", "박세종");
        ArticleCreateRequest request2 = new ArticleCreateRequest("타이틀2", "본문2", "박세종");

        //when
        Article article1 = articleService.createArticle(board, request1);
        Article article2 = articleService.createArticle(board, request2);

        //then
        assertThat(article1.getTitle()).isEqualTo("타이틀1");
        assertThat(article1.getBody()).isEqualTo("본문1");
        assertThat(article1.getAuthor()).isEqualTo("박세종");

        assertThat(article2.getTitle()).isEqualTo("타이틀2");
        assertThat(article2.getBody()).isEqualTo("본문2");
        assertThat(article2.getAuthor()).isEqualTo("박세종");
    }

    @Test
    public void modifyArticle() throws Exception {
        //given
        Board board = boardService.createBoard(new BoardCreateRequest("Java"));
        Article article = articleService.createArticle(board, new ArticleCreateRequest("타이틀1", "본문1", "박세종"));

        ArticleUpdateRequest request =  new ArticleUpdateRequest("title1", "body1");

        //when
        Article modifiedArticle = articleService.modifyArticle(article, request);

        //then
        assertThat(modifiedArticle.getTitle()).isEqualTo("title1");
        assertThat(modifiedArticle.getBody()).isEqualTo("body1");
        assertThat(modifiedArticle.getAuthor()).isEqualTo("박세종");
    }

}