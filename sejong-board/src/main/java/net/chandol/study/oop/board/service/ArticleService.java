package net.chandol.study.oop.board.service;

import net.chandol.study.oop.board.dto.ArticleRequest.ArticleCreateRequest;
import net.chandol.study.oop.board.dto.ArticleRequest.ArticleUpdateRequest;
import net.chandol.study.oop.board.model.Article;
import net.chandol.study.oop.board.model.ArticleRepository;
import net.chandol.study.oop.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article createArticle(Board board, ArticleCreateRequest request){
        Article article = new Article(board, request.getTitle(), request.getAuthor(), request.getBody());

        return articleRepository.save(article);
    }

    public Article modifyArticle(Article article, ArticleUpdateRequest request){
        article.modify(request.getTitle(), request.getBody());

        return articleRepository.save(article);
    }

    public Page<Article> getArticlePage(Board board, Pageable page){
        return articleRepository.findAll(page);
    }

}
