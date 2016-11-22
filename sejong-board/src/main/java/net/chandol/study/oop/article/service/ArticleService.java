package net.chandol.study.oop.article.service;

import net.chandol.study.oop.article.dto.ArticleCreateRequest;
import net.chandol.study.oop.article.dto.ArticleModifyRequest;
import net.chandol.study.oop.article.model.Article;
import net.chandol.study.oop.article.model.ArticleRepository;
import net.chandol.study.oop.article.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Article createArticle(ArticleCreateRequest request){
        Article article = new Article(request.getTitle(), request.getAuthor(), request.getPassword(), request.getBody(), Tag.create(request.getTags()));

        return articleRepository.save(article);
    }

    public Article modifyArticle(Article article, ArticleModifyRequest request){
        article.modify(request.getTitle(), request.getAuthor(), request.getPassword(), request.getBody(), Tag.create(request.getTags()));

        return articleRepository.save(article);
    }

    public Page<Article> getArticlePage(Pageable page){
        return articleRepository.findAll(page);
    }
}
