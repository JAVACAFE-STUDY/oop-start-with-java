package net.chandol.study.oop.article.service;

import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import net.chandol.study.oop.article.dto.ArticleUpdateRequest;
import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.model.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article createArticle(ArticleCreateRequest request){
        Article article = new Article(request.getTitle(), request.getAuthor(), request.getBody());

        return articleRepository.save(article);
    }

    public Article modifyArticle(Article article, ArticleUpdateRequest request){
        article.modify(request.getTitle(), request.getBody());

        return articleRepository.save(article);
    }

    public Page<Article> getArticlePage(Pageable page){
        return articleRepository.findAll(page);
    }
}
